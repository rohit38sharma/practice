package com.rohit.practice.leetcode.graph.dijkstras.LT1334;

import java.util.*;

public class CityWithSmallestNumberOfNeighbours {
    private class Node{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    private Map<Integer, ArrayList<Node>> graph;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        graph = new HashMap<>();

        for(int[] edge : edges){
            if(edge[2] <= distanceThreshold){
                graph.computeIfAbsent(edge[0], k1 -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
                graph.computeIfAbsent(edge[1], k1 -> new ArrayList<>()).add(new Node(edge[0], edge[2]));
            }
        }

        int city = n;
        int minConn = n;
        for(int i=n-1;i>=0;--i){
            int cityCount = findTheCityHelper(n, distanceThreshold, i);
            if(cityCount < minConn){
                city = i;
                minConn = cityCount;
            }
        }

        return city;

    }

    private int findTheCityHelper(int n, int distanceThreshold, int start){
        int cityCnt = 0;
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w-b.w);
        minTime[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.remove();
            for(Node nxtNode : graph.getOrDefault(cur.v, new ArrayList<>())){
                int dist = cur.w + nxtNode.w;
                if(dist <= distanceThreshold && dist < minTime[nxtNode.v]){
                    minTime[nxtNode.v] = dist;
                    pq.offer(new Node(nxtNode.v, minTime[nxtNode.v]));
                }
            }
        }
        for(int i=0;i<n;++i){
            if(i != start && minTime[i]<=distanceThreshold)
                ++cityCnt;
        }

        return cityCnt;
    }
}
