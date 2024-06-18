package Lecture06_Synchronisation;

public class CounterSynchronised {
    private int cnt;
    public CounterSynchronised(){
        cnt = 0;
    }
    synchronized void increment(){
        cnt++;
    }
    synchronized void decrement(){
        cnt--;
    }
    int getCnt(){
        return cnt;
    }
}
