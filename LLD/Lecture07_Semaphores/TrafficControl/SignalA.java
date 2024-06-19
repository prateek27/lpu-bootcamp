package Lecture07_Semaphores.TrafficControl;

import java.util.concurrent.Semaphore;

public class SignalA implements Runnable{
    Semaphore A;
    Semaphore B;
    public SignalA(Semaphore A,Semaphore B){
        this.A = A;
        this.B = B;
    }
    void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                A.acquire();
                System.out.println("Switching Lights from B to A");
                System.out.println("Signal A : Green");
                sleep(5);
                System.out.println("Signal A : Yellow");
                sleep(2);
                B.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Signal A : Red");
        }

    }
}
