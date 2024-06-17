package com.rohit.practice.leetcode.Array;

public class LT1014BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        if(n == 2){
            return values[0] + values[1] - 1;
        }

        int score = Integer.MIN_VALUE;
        int prevI = 0;

        for(int i=1;i<n;++i){
            score = Math.max(score, (values[prevI] + values[i] + (prevI - i)));
            if((values[prevI] - values[i]) <= (i - prevI)){
                prevI = i;
            }
        }

        return score;
    }
}
