package Lecture12_HLD;

import java.util.ArrayList;
import java.util.List;

public interface LoadBalancer {
    List<Server> servers = new ArrayList<>();
    public void addServer(Server s);
    public void removeServer(String serverId);
    public Server distributeLoad(Object request);
    public void healthCheck();
    public List<Server> getActiveServers();
}
