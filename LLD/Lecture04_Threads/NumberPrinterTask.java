package Lecture04_Threads;

public class NumberPrinterTask implements Runnable{
    int number;

    NumberPrinterTask(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number + " - " + Thread.currentThread().getName() );
    }
}
