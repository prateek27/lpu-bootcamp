package Lecture10_ExceptionHandling;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(5000);
                System.out.println("Thread wokeup successfully!");
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "was interrupted while sleeping!");
            }
        });
        //main starts a thread t
        t.start();
        //after 2s it it iterrupts the thread
        Thread.sleep(7000);
        System.out.println("T after 7 s" + t.getState());
        t.interrupt();
        System.out.println("We are in the main!");
    }
}
