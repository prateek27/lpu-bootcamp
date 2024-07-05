package Lecture12_HLD.MasterSlaveArchitecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = ()->System.out.println("Hello World!");
        executorService.scheduleAtFixedRate(task,2,3, TimeUnit.SECONDS);

        Thread.sleep(10000);

        executorService.shutdown();

    }
}
