package Lecture06_Synchronisation;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        //Thread creation using shared object

        Thread adderThread = new Thread(new AdderTask(counter));
        Thread subtracterThread = new Thread(new SubtracterTask(counter));
        System.out.println("Init Count" + counter.getCnt());

        //started the threads
        adderThread.start();
        subtracterThread.start();

        //wait for them to show the final result
        adderThread.join();
        subtracterThread.join();

        System.out.println("Final Count" + counter.getCnt());
    }
}
