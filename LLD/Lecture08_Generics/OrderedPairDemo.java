package Lecture08_Generics;

public class OrderedPairDemo {
    public static void main(String[] args) {
        OrderedPair<Integer,Integer> o1 = new OrderedPair<>(10,20);
        System.out.println(o1);
        OrderedPair<String,Integer> o2 = new OrderedPair<>("Heloo",10);
        System.out.println(o2);
    }
}
