package Lecture07_Semaphores.PC2.PC1;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    Queue<Object> queue;
    int maxCap;
    Semaphore ps;
    Semaphore cs;

    Producer(Queue<Object> q,int maxCap,Semaphore ps,Semaphore cs){
        this.queue = q;
        this.maxCap = maxCap;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public  void run() {
        while(true){
            try {
                ps.acquire();
                if(queue.size()<maxCap){
                    queue.add(new Object());
                    System.out.println("Added Tshirt, Queue Size is "+ queue.size());
                    cs.release();
                }
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
