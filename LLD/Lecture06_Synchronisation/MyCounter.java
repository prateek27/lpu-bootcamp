package Lecture06_Synchronisation;

import java.util.concurrent.atomic.AtomicInteger;

public class MyCounter {
    AtomicInteger count;
    MyCounter(){
        count = new AtomicInteger(0);
        count.addAndGet(6);
    }
}
