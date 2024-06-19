package Lecture07_Semaphores.PC2.PC1;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Queue<Object> queue;
    int maxCap;
    Semaphore ps;
    Semaphore cs;

    Consumer(Queue<Object> q,int maxCap,Semaphore ps,Semaphore cs){
        this.queue = q;
        this.maxCap = maxCap;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {
        while(true){
            try {
                cs.acquire();
                if(queue.size()>0){
                    queue.remove();
                    System.out.println("Removed Tshirt, Queue Size is "+ queue.size());
                }
                ps.release();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
