package com.rohit.practice.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LT210CourseScheduleII {
    private HashMap<Integer, ArrayList<Integer>> graph;
    private boolean[] visited;
    private int[] courseorder;
    private Stack<Integer> order;
    private HashMap<Integer,Integer> position;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1)
            return new int[numCourses];

        initialisation(numCourses);
        prepareGraph(prerequisites);
        topologicalSort(numCourses);
        prepareOrder();
        boolean isCyclic = detectCycle(numCourses);

        if(isCyclic)
            return new int[0];

        return courseorder;
    }

    private void initialisation(int numCourses){
        courseorder = new int[numCourses];
        graph = new HashMap<>();
        visited = new boolean[numCourses];
        order = new Stack<>();
        position = new HashMap<>();

    }

    private void prepareGraph(int[][] prerequisites){

        int edges = prerequisites.length;

        for(int i=0;i<edges;++i){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
    }

    private void topologicalSort(int numCourses){
        for(int v=0;v<numCourses;++v){
            if(!visited[v]){
                topologicalSortDfs(v);
            }
        }
    }

    private void topologicalSortDfs(int v){
        visited[v] = true;
        ArrayList<Integer> edges = graph.getOrDefault(v, new ArrayList<>());
        for(int e : edges){
            if(!visited[e]){
                topologicalSortDfs(e);
            }
        }

        order.push(v);
    }

    private void prepareOrder(){
        int idx = 0;
        while(!order.isEmpty()){
            int cur = order.pop();
            courseorder[idx] = cur;
            position.put(cur, idx);
            ++idx;
        }
    }

    private boolean detectCycle(int numCourses){
        for(int v=0;v<numCourses;++v){
            int posv = position.get(v);
            ArrayList<Integer> edges = graph.getOrDefault(v, new ArrayList<>());
            for(int e : edges){
                if(posv >= position.get(e)){
                    return true;
                }
            }
        }

        return false;
    }
}
