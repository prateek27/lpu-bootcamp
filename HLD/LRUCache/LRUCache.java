package Lecture12_HLD.LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    int capacity;
    Storage storage;
    //Business Logic
    HashMap<String,Object> cacheStorage;


    public LRUCache(int capacity, Storage storage){
        this.capacity = capacity;
        this.storage = storage;
        this.cacheStorage = new LinkedHashMap<>();
    }

    public Object get(String key){
        if(cacheStorage.containsKey(key)){
            //to make this key as most recently used
            Object value = cacheStorage.get(key);
            cacheStorage.remove(key);
            cacheStorage.put(key,value);
            return value;
        }
        else{
            Object value = storage.read(key);
            put(key,value);
            return value;
        }
    }
    public void put(String key,Object value){
        if(cacheStorage.size()<capacity){
            cacheStorage.put(key,value);
        }
        else{
            //remove the oldest key (least recently used)
            lruEviction();
            cacheStorage.put(key,value);
        }
    }

    void lruEviction(){
        //Eviction of least recently used key-value from the map
        Iterator it = cacheStorage.keySet().iterator();
        if(it.hasNext()){
            cacheStorage.remove(it.next());
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", storage=" + storage +
                ", cacheStorage=" + cacheStorage +
                '}';
    }
}
