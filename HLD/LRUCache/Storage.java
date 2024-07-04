package Lecture12_HLD.LRUCache;

public interface Storage {
    Object read(String key);
    void write(String key,Object value);
}
