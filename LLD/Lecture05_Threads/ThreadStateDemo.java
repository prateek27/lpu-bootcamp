package Lecture05_Threads;

public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Teacher());
        t.start();
        System.out.println("Main is running!");
        Thread.sleep(2000);
        System.out.println(t.getState());
    }
}
