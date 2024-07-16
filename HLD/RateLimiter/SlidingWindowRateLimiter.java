package Lecture12_HLD.RateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimiter {
    private int maxRequests;
    private long windowSize; // time
    private Queue<Long> queue;

    public SlidingWindowRateLimiter(int maxRequests,int windowSize){
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.queue = new LinkedList<>();
    }


    @Override
    public boolean allowRequest() {
        long currentTime = System.nanoTime();
        //remove the obselote requests
        while(!queue.isEmpty() && queue.peek() <= currentTime - windowSize*1_000_000_000){
            queue.poll();
        }
        //add the fresh request if q size is less than capacity
        if(queue.size()<maxRequests){
            queue.add(currentTime);
            return true;
        }
        else{
            return false;
        }
    }
}
