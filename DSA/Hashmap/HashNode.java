package CompetitiveProgramming.Hashmap;

public class HashNode<K,V> {
    K key;
    V value;
    HashNode<K,V> next;

    public HashNode(K key,V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
