package com.rohit.practice.leetcode.graph.dijkstras;

import java.util.*;

public class LT1514PathwithMaximumProbability {
    private class Node{
        int key;
        double prob;

        public Node(int key, double prob){
            this.key = key;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        double[] maxProb = new double[n];

        boolean[] visited = new boolean[n];

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.prob<b.prob ?1 :-1);

        Map<Integer, List<Node>> graph = new HashMap<>();

        int e = edges.length;
        for(int i=0; i<e; ++i){
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, pathProb));
        }

        if(!graph.containsKey(start_node) || !graph.containsKey(end_node))
            return 0.0;

        maxProb[start_node] = 1.0;

        pq.offer(new Node(start_node, 1));

        while(!pq.isEmpty() && !visited[end_node]){
            Node cur = pq.remove();
            visited[cur.key] = true;
            for(Node nxt : graph.getOrDefault(cur.key, new ArrayList<>())){
                if(!visited[nxt.key] && (cur.prob * nxt.prob > maxProb[nxt.key])){
                    maxProb[nxt.key] = cur.prob * nxt.prob;
                    pq.offer(new Node(nxt.key, maxProb[nxt.key]));
                }
            }
        }

        return maxProb[end_node];
    }
}
