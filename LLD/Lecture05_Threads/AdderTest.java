package Lecture05_Threads;

import java.util.concurrent.*;

public class AdderTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> output = executor.submit(new Adder(5,8));
        //some work here

        System.out.println("Main is doing some work!");
        //you need the result of calculation
        System.out.println(output.get()); //blocking operation
    }
}
