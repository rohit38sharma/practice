package com.rohit.practice.leetcode.dp;

public class LT931MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;

        return minFallingPathSumDp(matrix, n, m);

    }

    private int minFallingPathSumDp(int[][] matrix, int n, int m) {
        int[] dp = new int[m];

        for(int j=0;j<m;++j){
            dp[j] = matrix[n-1][j];
        }

        for(int i=n-2;i>=0;--i){
            int[] cur = new int[m];

            for(int j=0;j<m;++j){
                cur[j] = dp[j];
                if(j>0){
                    cur[j] = Math.min(cur[j], dp[j-1]);
                }
                if(j<m-1){
                    cur[j] = Math.min(cur[j], dp[j+1]);
                }
                cur[j] += matrix[i][j];
            }

            dp = cur;
        }

        int minSum = dp[0];
        for(int i=1;i<m;++i){
            minSum = Math.min(minSum, dp[i]);
        }

        return minSum;
    }
}
