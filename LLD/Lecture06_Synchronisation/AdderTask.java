package Lecture06_Synchronisation;

public class AdderTask implements Runnable{

    Counter counter;
    AdderTask(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }
}
