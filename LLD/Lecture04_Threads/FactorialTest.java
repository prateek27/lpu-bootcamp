package Lecture04_Threads;

import java.math.BigInteger;

public class FactorialTest {

    public static void main(String[] args) throws InterruptedException {
        FactorialThread t = new FactorialThread(100);
        t.start();

        System.out.println("doing some other calculation");

        t.join();
        System.out.println(t.ans);
        System.out.println("Main is runnnig!");

    }
}
