package Lecture12_HLD.RateLimiter;

public class TokenBucketRateLimiter implements RateLimiter{
    private int capacity;
    private int refillRate;
    private int tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity,int refillRate){
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.nanoTime();
    }
    private void refill(){
        long currentTime = System.nanoTime();
        int tokensToAdd = (int)(currentTime-lastRefillTimestamp)/1_000_000_000*refillRate;
        tokens = Math.min(tokens + tokensToAdd,capacity);
        lastRefillTimestamp = System.nanoTime();
    }
    @Override
    public boolean allowRequest() {
        refill();
        if(tokens>0){

            tokens --;
            return true;
        }
        else{
            return false;
        }
    }
}
