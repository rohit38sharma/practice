package com.rohit.practice.leetcode.greedy;

import java.util.Arrays;

public class LT826MostProfitAssigningWork {
    //Optimised solution
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max = 0;
        for(int w : worker){
            max = Math.max(max, w);
        }

        int[] jobs = new int[max + 1];

        for(int i=0;i<difficulty.length;++i){
            if(difficulty[i] <= max){
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        for(int i=1;i<=max;++i){
            jobs[i] = Math.max(jobs[i], jobs[i-1]);
        }

        int totalProfit = 0;

        for(int i=0;i<worker.length;++i){
            totalProfit += jobs[worker[i]];
        }

        return totalProfit;
    }


    private class Job{
        int d;
        int p;

        public Job(int d, int p){
            this.d = d;
            this.p = p;
        }
    }
    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        Job[] jobs = new Job[n];

        for(int i=0;i<n;++i){
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.p - b.p);

        Arrays.sort(worker);

        int i=n-1, j=m-1;
        int totalProfit = 0;

        while(i>=0 && j>=0){
            if(worker[j] >= jobs[i].d){
                totalProfit += jobs[i].p;
                --j;
            }else{
                --i;
            }
        }

        return totalProfit;
    }
}
