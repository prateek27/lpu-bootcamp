package Lecture12_HLD.RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Achieve Loose Coupling using Intefaces (Abstraction)
        Server s1 = new Server(new TokenBucketRateLimiter(5,2));;
        Server s = new Server(new SlidingWindowRateLimiter(5,2));
        for(int i=0;i<=100;i++){
            s.handleRequest(new Object());
            Thread.sleep(2000);
        }
    }
}
