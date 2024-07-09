package com.rohit.practice.leetcode.Array;

public class LT1482MinNumDayMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(m*k<0 || m*k>n)
            return -1;

        int s=0, e = 0;

        for(int val : bloomDay){
            e = Math.max(e, val);
        }


        int minDays = -1;
        while(s <= e){
            int mid = (s + e)/2;
            int bouquets = bouquetsOnDays(bloomDay, m, k, mid);

            if(bouquets >= m){
                minDays = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return minDays;
    }

    private int bouquetsOnDays(int[] bloomDay, int m, int k, int days){
        int n = bloomDay.length;
        int bouquets = 0, count = 0;
        int i = 0;
        while(i<n && bouquets < m){
            if(bloomDay[i] <= days){
                ++count;
            }else{
                count = 0;
            }

            if(count == k){
                ++bouquets;
                count = 0;
            }

            ++i;
        }

        return bouquets;
    }
}
