package Lecture12_HLD;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinLoadBalancer implements LoadBalancer{
    private int index = 0;
    @Override
    public void addServer(Server server) {
        servers.add(server);
    }

    @Override
    public void removeServer(String serverId) {
        servers.removeIf((server -> server.getId().equals(serverId)));
    }

    @Override
    public Server distributeLoad(Object request) {
        //corner case
        if(servers.isEmpty()){
            return null;
        }
        //find the next available in the sequence
        int attempts = 0;
        while(true) {
            if(attempts>=servers.size()){
                return null;
            }
            Server server = servers.get(index);
            index = (index + 1) % servers.size();
            if (server.isHealth()) {
                return server;
            }
            attempts++;
        }
    }

    @Override
    public void healthCheck() {


        for(Server s:servers){
            double random = Math.random(); //0-1
            //prob of getting this number 10%
            if(random<=0.3){
                s.setStatus(false);
            }
        }
    }

    @Override
    public List<Server> getActiveServers() {
        List<Server> activeServers = new ArrayList<>();
        for(Server s:servers){
            if(s.isHealth()){
                activeServers.add(s);
            }
        }
       return activeServers;
    }
}
