package Lecture07_Semaphores.PC1;

import java.util.Queue;

public class Consumer implements Runnable{
    Queue<Object> queue;
    int maxCap;

    Consumer(Queue<Object> q,int maxCap){
        this.queue = q;
        this.maxCap = maxCap;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                if(queue.size()>0){
                    queue.remove();
                    System.out.println("Removed Tshirt, Queue Size is "+ queue.size());
                }
            }
        }
    }
}
