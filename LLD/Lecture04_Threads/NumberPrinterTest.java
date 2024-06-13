package Lecture04_Threads;

public class NumberPrinterTest {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            Thread t = new Thread(new NumberPrinterTask(i));
            t.start();
        }
    }
}
