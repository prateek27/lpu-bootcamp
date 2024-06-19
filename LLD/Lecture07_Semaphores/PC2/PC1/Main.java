package Lecture07_Semaphores.PC2.PC1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //Queue
        Queue<Object> queue = new LinkedList<>();
        final int MAX_CAP = 5;

        Semaphore producerSemaphore = new Semaphore(MAX_CAP);
        Semaphore consumerSemaphore = new Semaphore(0);


        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i<=5;i++){
            threads.add(new Thread(new Producer(queue,MAX_CAP,producerSemaphore,consumerSemaphore)));
        }

        for(int i=0; i<=3;i++){
            threads.add(new Thread(new Consumer(queue,MAX_CAP,producerSemaphore,consumerSemaphore)));
        }

        for(Thread t:threads){
            t.start();
        }



    }
}
