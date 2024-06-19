package Lecture07_Semaphores.TrafficControl;

import java.util.concurrent.Semaphore;

public class SignalB implements Runnable{
    Semaphore A;
    Semaphore B;
    public SignalB(Semaphore A,Semaphore B){
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
                B.acquire();
                System.out.println("Switching Lights from A to B");
                System.out.println("Signal B : Green");
                sleep(5);
                System.out.println("Signal B : Yellow");
                sleep(2);
                A.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Signal B : Red");
        }
    }
}
