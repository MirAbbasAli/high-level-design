package io.loadbalancer.util;

import java.util.Arrays;
import java.util.List;

public class RoundRobin {
    private List<String> servers;
    private Integer currentServer;

    public RoundRobin(String[] servers){
        this.servers = Arrays.asList(servers);
        this.currentServer = -1;
    }

    public String getNextServer(){
        currentServer = (currentServer + 1) % servers.size();
        return servers.get(currentServer);
    }
}
