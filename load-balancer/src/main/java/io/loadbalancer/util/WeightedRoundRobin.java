package io.loadbalancer.util;

import java.util.Arrays;
import java.util.List;

public class WeightedRoundRobin {
    private List<String> servers;
    private List<Integer> weights;
    private Integer currentServer;
    private Integer currentWeight;
    public WeightedRoundRobin(String[] servers, Integer[] weights){
        this.servers = Arrays.asList(servers);
        this.weights = Arrays.asList(weights);
        this.currentServer = -1;
        this.currentWeight = -1;
    }

    public String getNextServer(){
        if (currentWeight <= 0) {
            currentServer = (currentServer + 1) % servers.size();
            currentWeight = weights.get(currentServer);
        }
        currentWeight -= 1;
        return servers.get(currentServer);
    }
}
