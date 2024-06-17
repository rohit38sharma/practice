package com.rohit.practice.leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LT502IPO {
    private class Project{
        int capital;
        int profit;

        public Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        for(int i=0;i<n;++i){
            projects.add(new Project(capital[i], profits[i]));
        }

        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int idx = 0;

        while(k-->0){

            while(idx<n && w >= projects.get(idx).capital){
                pq.offer(projects.get(idx));
                ++idx;
            }

            if(pq.isEmpty())
                break;

            w += pq.remove().profit;
        }

        return w;
    }
}
