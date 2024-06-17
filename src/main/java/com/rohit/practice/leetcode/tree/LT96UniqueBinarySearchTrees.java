package com.rohit.practice.leetcode.tree;

import java.util.Arrays;

public class LT96UniqueBinarySearchTrees {

    //Iterative DP: Bottom Up
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2;i<=n;++i){
            int bsts = 0;
            for(int j=0;j<i;++j){
                if(dp[j] == 0){
                    bsts += dp[i-j-1];
                }else if(dp[i-j-1] == 0){
                    bsts += dp[j];
                }else{
                    bsts += (dp[j] * dp[i-j-1]);
                }
            }

            dp[i] = bsts;
        }

        return dp[n];
    }

    //Backtracking and memoisation: Top down
    private long countBSTs(int n){
        if(n<=1)
            return n;

        long[] memo = new long[n+1];
        Arrays.fill(memo, -1l);
        return countBSTHelper(n, 1, n, memo);
    }

    private long countBSTHelper(int n, int s, int e, long[] memo){
        if(s > e)
            return 0;
        if(memo[e-s+1] != -1){
            return memo[e-s+1];
        }
        if(e-s+1 == 1){
            return 1;
        }

        long numBsts = 0;
        for(int i=s; i<=e; ++i){
            long left = countBSTHelper(n, s, i-1, memo);
            long right = countBSTHelper(n, i+1, e, memo);
            if(left == 0)
                numBsts += right;
            else if(right == 0)
                numBsts += left;
            else
                numBsts += (left * right);
        }
        memo[e-s+1] = numBsts;
        return numBsts;

    }
}
