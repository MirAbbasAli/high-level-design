package io.loadbalancer;

import io.loadbalancer.util.RoundRobin;
import io.loadbalancer.util.WeightedRoundRobin;

import java.util.stream.IntStream;


public class LoadBalancerApp {
    private static final String[] servers = {"server1", "server2", "server3", "server4"};
    public static void testRoundRobin(){
        RoundRobin loadBalancer = new RoundRobin(servers);
        for(int requestNum = 0; requestNum <= 10; requestNum++){
            System.out.printf("Request %d -> %s%n", requestNum, loadBalancer.getNextServer());
        }
    }

    public static void testWeightRoundRobin(){
        Integer[] weights = {5, 4, 3, 2};
        WeightedRoundRobin loadBalancer = new WeightedRoundRobin(servers, weights);
        IntStream.range(0, 20)
                .forEach(request ->{
                    System.out.printf("Request %d -> %s%n", request, loadBalancer.getNextServer());
                });
    }
    public static void main(String[] args){
//        testRoundRobin();
        testWeightRoundRobin();
        System.out.println();
    }
}
