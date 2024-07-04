package Lecture12_HLD.LRUCache;

public class ProblemService {
    private Storage storage;
    private LRUCache cache;

    public ProblemService(int cacheCapacity,Storage storage){
        this.storage = storage;
        cache = new LRUCache(cacheCapacity,storage);
    }
    public Object getTestCase(String key){
        return cache.get(key);
    }
}
