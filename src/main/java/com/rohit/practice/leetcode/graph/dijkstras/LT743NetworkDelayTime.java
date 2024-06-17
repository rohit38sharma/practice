package com.rohit.practice.leetcode.graph.dijkstras;

import java.util.*;

public class LT743NetworkDelayTime {
    private class Node{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n+1];
        Map<Integer, ArrayList<Node>> graph = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w-b.w);

        Arrays.fill(minTime, -1);

        for(int[] time : times){
            graph.computeIfAbsent(time[0], k1 -> new ArrayList<>()).add(new Node(time[1], time[2]));
        }

        minTime[k] = 0;
        pq.offer(new Node(k, 0));

        while(!pq.isEmpty()){
            Node cur = pq.remove();
            for(Node nxtNode : graph.getOrDefault(cur.v, new ArrayList<>())){
                if(minTime[nxtNode.v]==-1 || cur.w + nxtNode.w < minTime[nxtNode.v]){
                    minTime[nxtNode.v] = cur.w + nxtNode.w;
                    pq.offer(new Node(nxtNode.v, minTime[nxtNode.v]));
                }
            }
        }

        int maxTime = 0;
        for(int i=1;i<=n;++i){
            if(minTime[i] == -1)
                return -1;
            maxTime = Math.max(maxTime, minTime[i]);
        }

        return maxTime;

    }
}
