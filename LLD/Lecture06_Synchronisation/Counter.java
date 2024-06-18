package Lecture06_Synchronisation;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int cnt;
    public Counter(){
        cnt = 0;
    }
    void increment(){
        synchronized (this){
            cnt++;
        }

    }
    void decrement(){
        synchronized (this){
            cnt--;
        }

    }
    int getCnt(){
        return cnt;
    }
}
