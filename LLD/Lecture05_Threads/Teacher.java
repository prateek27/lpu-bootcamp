package Lecture05_Threads;

public class Teacher implements Runnable{

    @Override
    public void run() {
        System.out.println("Wait for 5s inside teacher");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("I am teaching!");
    }
}
