package CompetitiveProgramming.Hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class HashMap<K,V> {
    private ArrayList<HashNode<K,V>> bucketArray;
    private int numOfBuckets;
    private int size;

    private int hashFn(K key){
        int hashCode = Objects.hashCode(key);
        return (hashCode & 0x7FFFFFFF) % numOfBuckets;

    }
    private void rehash(){
        ArrayList<HashNode<K,V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        numOfBuckets *= 2;
        size = 0;
        for(int i=0;i<numOfBuckets;i++){
            bucketArray.add(null);
        }

        //iterate on original 'heads' and put data here
        for(HashNode<K,V> bucketHead:temp){
            HashNode<K,V> head = bucketHead;
            while(head!=null){
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public HashMap(int defaultSize){
        numOfBuckets = defaultSize;
        size = 0;
        //init the arraylist with null values
        bucketArray = new ArrayList<>();
        for(int i=0;i<numOfBuckets;i++){
            bucketArray.add(null);
        }
    }


    public void insert(K key,V value){
        //Get the Bucket Id & Node
        int bucketId = hashFn(key);
        HashNode<K,V> bucketHead = bucketArray.get(bucketId);
        //Creating the Node
        HashNode<K,V> newNode = new HashNode<>(key, value);
        //Attaching the Node
        newNode.next = bucketHead;
        bucketArray.set(bucketId,newNode);

        //Rehashing
        size++;
        float loadFactor = size/(float)numOfBuckets;
        if(loadFactor>0.75){
            System.out.println("Rehashing the table");
            rehash();
        }
    }

    V search(K key){
        int bucketId = hashFn(key);
        HashNode<K,V> bucketHead = bucketArray.get(bucketId);

        while(bucketHead!=null){
            if(bucketHead.key==key){
                return bucketHead.value;
            }
            bucketHead = bucketHead.next;
        }
        return null;
    }

}
