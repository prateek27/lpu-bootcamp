package Lecture07_Semaphores.TrafficControl;
//Problem Statement:
// Implement a program that simulaties traffic intersection control system
// using java semaphores, the intersection has 2 road each with its
// traffic signal. Only one road should have green light at time while
// the other road has red light.
// The interesection should allow smooth transition
// between green lights for both the roads.

// Requirements
// the duration of each R,Y, G can be adjusted by the user
// Each road signal should run in separate thread

// Sample Output
// Road A: Green, Road B : Red
// ...sometime after ...
// Road A: Yellow, Road B: Red
// Road A : Red, Road : Green


import java.util.concurrent.Semaphore;

public class TrafficControlDemo {
    public static void main(String[] args) {
        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);

        Thread t1 = new Thread(new SignalA(A,B));
        Thread t2 = new Thread(new SignalB(A,B));

        t1.start();
        t2.start();
    }
}
