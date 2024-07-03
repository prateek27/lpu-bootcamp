package Lecture12_HLD;

public class LoadBalancerTest {
    public static void main(String[] args) {
        LoadBalancer lb = new RoundRobinLoadBalancer();
        lb.addServer(new Server("S1"));
        lb.addServer(new Server("S2"));
        lb.addServer(new Server("S3"));
        lb.addServer(new Server("S4"));

        lb.healthCheck();

        System.out.println(lb.getActiveServers());

        //Load Balancer Test
        System.out.println("Request1 goes to "+lb.distributeLoad(new Object()));
        System.out.println("Request2 goes to "+lb.distributeLoad(new Object()));
        System.out.println("Request3 goes to "+lb.distributeLoad(new Object()));
        System.out.println("Request4 goes to "+lb.distributeLoad(new Object()));

    }
}
