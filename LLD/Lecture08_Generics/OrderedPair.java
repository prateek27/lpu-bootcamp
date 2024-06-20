package Lecture08_Generics;

public class OrderedPair<K,V> implements Pair<K,V>{

    K key;
    V value;

    OrderedPair(K key,V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "OrderedPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
