package Lecture12_HLD.RateLimiter;

public class Server {
    RateLimiter rateLimiter;

    Server(RateLimiter rateLimiter){
        this.rateLimiter = rateLimiter;
    }
    void handleRequest(Object request){
        if(rateLimiter.allowRequest()){
            System.out.println("Processing the data");
        }
        else{
            System.out.println("Can't process, limit exceeded");
        }
    }
}
