package Lecture05_Threads;

import Lecture04_Threads.NumberPrinterTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {

        //Print 100 numbers using 5 threads
        //re-use the same threads
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0;i<=100;i++){
            executor.submit(new NumberPrinterTask(i));
        }
    }
}
