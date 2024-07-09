package com.rohit.practice.leetcode.Array;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        List<Integer> task_memory = new ArrayList<>();
        task_memory.add(1);
        task_memory.add(2);
        task_memory.add(3);
        task_memory.add(4);
        task_memory.add(2);

        List<Integer> task_type = new ArrayList<>();
        task_type.add(1);
        task_type.add(2);
        task_type.add(1);
        task_type.add(2);
        task_type.add(3);

        System.out.println(getMinTime(task_memory, task_type, 4));
    }

    private static int getMinTime(List<Integer> task_memory, List<Integer> task_type, int max_memory){
        int n = task_memory.size();
        if(n<=1){
            return n;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;++i){
            map.computeIfAbsent(task_type.get(i), k -> new ArrayList<>()).add(task_memory.get(i));
        }

        int time = 0;

        for(int t : map.keySet()){
            List<Integer> tasks = map.get(t);
            Collections.sort(tasks);
            int len = tasks.size();
            int i=0, j=len-1;

            while(i<=j){
                if(i!=j && tasks.get(i) + tasks.get(j) <= max_memory){
                    ++i;
                }
                --j;
                ++time;
            }
        }

        return time;

    }
}
