package com.rohit.practice.leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT834SumofDistancesinTree {
    private Map<Integer, List<Integer>> graph;
    private int[] nodeCount;
    private int[] distanceSum;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        distanceSum = new int[n];

        if(n <= 0){
            return distanceSum;
        }

        nodeCount = new int[n];
        graph = new HashMap<>();

        populateGraph(edges);

        int rootSum = countTreeNodes(0, -1);
        distanceSum[0] = rootSum;

        calculateDistanceSum(n, 0, -1);

        return distanceSum;
    }

    private void populateGraph(int[][] edges){
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

    private int countTreeNodes(int node, int parent){
        nodeCount[node] = 1;
        int sum = 0;
        List<Integer> childs = graph.getOrDefault(node, new ArrayList<>());
        for(int child : childs){
            if(child != parent){
                int childSum = countTreeNodes(child, node);
                sum += childSum + nodeCount[child];
                nodeCount[node] += nodeCount[child];
            }
        }

        return sum;
    }

    private void calculateDistanceSum(int n, int node, int parent){
        if(parent != -1){
            distanceSum[node] = distanceSum[parent] - nodeCount[node] + (n - nodeCount[node]);
        }

        List<Integer> childs = graph.getOrDefault(node, new ArrayList<>());
        for(int child : childs){
            if(child != parent){
                calculateDistanceSum(n, child, node);
            }
        }
    }
}
