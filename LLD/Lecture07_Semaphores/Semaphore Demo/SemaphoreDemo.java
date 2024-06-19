package Lecture07_Semaphores;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Thread worker = new Thread(new Worker(i));
            worker.start();
        }
    }
    static class Worker implements Runnable{
        private final int workerId;

        Worker(int workerId) {
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(workerId + "enters the park");
                Thread.sleep(3000);
                System.out.println(workerId + "exits the park");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
