package Lecture08_Generics;

import java.util.HashMap;

public class BoxDemo {
    public static void main(String[] args) {
        Box<Integer,Integer> b1 = new Box(1,2);
        Box<String,String> b2 = new Box("Sparrow","Bulbul");
        Box<Integer,String> b3 = new Box(10,"Helo");

        int x1 = b1.getX();
        String x2 = b2.getX();
        System.out.println(x1+ x2);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
