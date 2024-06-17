package com.rohit.practice.leetcode.graph.bfs;

import java.util.*;

public class LT310MinimumHeightTrees {
    private Map<Integer, List<Integer>> connections;
    private Map<Integer, List<Integer>> heightRoots;
    private int mht;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Collections.singletonList(0);
        }
        return findMinHeightTreesBfsOptimised(n, edges);
    }


    //Time Complexity: O(E + N)
    public List<Integer> findMinHeightTreesBfsOptimised(int n, int[][] edges) {
        connections = new HashMap<>();
        int[] count = new int[n];

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            connections.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            connections.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            count[u]++;
            count[v]++;
        }

        Queue<Integer> level = new LinkedList<>();
        for(int i=0;i<n;++i){
            if(count[i] == 1){
                level.add(i);
            }
        }

        int rootsCandidates = n;

        while(rootsCandidates > 2){
            int size = level.size();
            for(int i=0;i<size;++i){
                int cur = level.remove();
                List<Integer> adjacent = connections.getOrDefault(cur, new ArrayList<>());
                for(int v : adjacent){
                    if(--count[v] == 1){
                        level.add(v);
                    }
                }
            }
            rootsCandidates -= size;
        }

        List<Integer> mhts = new ArrayList<>();
        while(!level.isEmpty()){
            mhts.add(level.remove());
        }

        return mhts;
    }

    private void initialisation(){
        connections = new HashMap<>();
        heightRoots = new HashMap<>();
        mht = Integer.MAX_VALUE;
    }

    public List<Integer> findMinHeightTreesBfs(int n, int[][] edges) {

        initialisation();
        prepareGraph(edges);
        findAllMhTs(n);

        return heightRoots.getOrDefault(mht, new ArrayList<>());
    }

    private void prepareGraph(int[][] edges){
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            connections.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            connections.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }


    //Time Complexity: O(N * E)
    private void findAllMhTs(int n){
        for(int h=0; h<n; ++h){

            boolean[] visited = new boolean[n];
            visited[h] = true;

            Queue<Integer> level = new LinkedList<>();
            level.offer(h);

            int height = 0;

            while(!level.isEmpty()){
                int count = level.size();
                for(int i=0;i<count;++i){
                    int curnode = level.remove();
                    List<Integer> adjacent = connections.getOrDefault(curnode, new ArrayList<>());
                    for(int v : adjacent){
                        if(!visited[v]){
                            visited[v] = true;
                            level.offer(v);
                        }
                    }
                }

                ++height;
            }

            heightRoots.computeIfAbsent(height, k -> new ArrayList<>()).add(h);
            mht = Math.min(mht, height);
        }
    }
}
