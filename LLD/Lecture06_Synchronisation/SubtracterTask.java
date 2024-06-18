package Lecture06_Synchronisation;


public class SubtracterTask implements Runnable{

    Counter counter;
    SubtracterTask(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            counter.decrement();
        }
    }
}
