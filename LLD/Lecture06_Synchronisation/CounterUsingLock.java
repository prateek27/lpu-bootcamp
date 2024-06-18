package Lecture06_Synchronisation;

import java.util.concurrent.locks.ReentrantLock;

public class CounterUsingLock {
    private int cnt;
    ReentrantLock lock = new ReentrantLock();
    public CounterUsingLock(){
        cnt = 0;
    }
    void increment(){
        lock.lock();
        cnt++;
        lock.unlock();
    }
    void decrement(){
        lock.lock();
        cnt--;
        lock.unlock();
    }
    int getCnt(){
        return cnt;
    }

}
