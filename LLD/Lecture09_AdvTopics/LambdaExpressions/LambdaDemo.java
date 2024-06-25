package Lecture09_AdvTopics.LambdaExpressions;

public class LambdaDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new HelloTask());
        t.start();

        //Directly create threads
        Thread t2 = new Thread(()->{
            System.out.println("Greeting from another thread!" + Thread.currentThread().getName());
        });

        Thread t3 = new Thread(()->{
            System.out.println("Denoising the img!" + Thread.currentThread().getName());
        });

        t2.start();
        t3.start();
    }
}
