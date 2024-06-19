package Lecture07_Semaphores.PC1;

import java.util.Queue;

public class Producer implements Runnable{
    Queue<Object> queue;
    int maxCap;

    Producer(Queue<Object> q,int maxCap){
        this.queue = q;
        this.maxCap = maxCap;
    }

    @Override
    public  void run() {
        while(true){
            synchronized (queue){
                if(queue.size()<maxCap){
                    queue.add(new Object());
                    System.out.println("Added Tshirt, Queue Size is "+ queue.size());
                }
            }

        }
    }
}
