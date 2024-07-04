package Lecture12_HLD.LRUCache;

import java.util.HashMap;

public class ObjectStorage implements Storage {
    HashMap<String,Object> hashMap;

    ObjectStorage(){
        hashMap = new HashMap<>();
    }

    public Object read(String key){
        return hashMap.get(key);
    }
    public void write(String key,Object value){
        hashMap.put(key,value);
    }

    @Override
    public String toString() {
        return "ObjectStorage{" +
                "hashMap=" + hashMap +
                '}';
    }
}
