package com.rohit.practice.leetcode.dp;

import java.util.Arrays;

public class LT1289MinimumFallingPathSumII {
    private int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows <= 0)
            return 0;
        int cols = grid[0].length;

        dp = new int[rows][cols];

        return minFallingPathSumSpaceOpt(grid, rows, cols);

    }


    /*
    Approach: Iterative Bottom up DP
    Time : O(N^2)
    Space : O(1)
    */
    private int minFallingPathSumSpaceOpt(int[][] grid, int rows, int cols) {

        int min1_idx = -1, min2_idx = -1;
        int min1_val = Integer.MAX_VALUE, min2_val = Integer.MAX_VALUE;

        for(int j=0;j<cols;++j){
            //dp[rows-1][j] = grid[rows-1][j];

            if(grid[rows-1][j] <= min1_val){
                min2_val = min1_val;
                min2_idx = min1_idx;
                min1_val = grid[rows-1][j];
                min1_idx = j;
            }else if(grid[rows-1][j] < min2_val){
                min2_val = grid[rows-1][j];
                min2_idx = j;
            }
        }

        for(int i=rows-2;i>=0;--i){
            int min1_idx_t = -1, min2_idx_t = -1;
            int min1_val_t = Integer.MAX_VALUE, min2_val_t = Integer.MAX_VALUE;
            for(int j=0;j<cols;++j){
                int value  = grid[i][j];
                if(min1_idx != j){
                    value += min1_val;
                }else{
                    value += min2_val;
                }

                if(value <= min1_val_t){
                    min2_val_t = min1_val_t;
                    min2_idx_t = min1_idx_t;
                    min1_val_t = value;
                    min1_idx_t = j;
                }else if(value < min2_val_t){
                    min2_val_t = value;
                    min2_idx_t = j;
                }
            }

            min1_val = min1_val_t;
            min2_val = min2_val_t;
            min1_idx = min1_idx_t;
            min2_idx = min2_idx_t;
        }

        return min1_val;
    }

    /*
    Approach: Iterative Bottom up DP
    Time : O(N^2)
    Space : O(N^2)
    */
    private int minFallingPathSumIt(int[][] grid, int rows, int cols) {

        int min1 = -1, min2 = -1;

        for(int j=0;j<cols;++j){
            dp[rows-1][j] = grid[rows-1][j];

            if(min1 == -1 || grid[rows-1][j] <= grid[rows-1][min1]){
                min2 = min1;
                min1 = j;
            }else if(min2 == -1 || grid[rows-1][j] < grid[rows-1][min2]){
                min2 = j;
            }
        }

        for(int i=rows-2;i>=0;--i){
            int min1_t = -1;
            int min2_t = -1;
            for(int j=0;j<cols;++j){
                if(min1 != j){
                    dp[i][j] = dp[i+1][min1] + grid[i][j];
                }else{
                    dp[i][j] = dp[i+1][min2] + grid[i][j];
                }

                if(min1_t == -1 || dp[i][j] <= dp[i][min1_t]){
                    min2_t = min1_t;
                    min1_t = j;
                }else if(min2_t == -1 || dp[i][j] < dp[i][min2_t]){
                    min2_t = j;
                }
            }

            min1 = min1_t;
            min2 = min2_t;
        }

        return dp[0][min1];
    }

    /*
    Approach: Recursice Top down DP
    Time : O(N^3)
    Space : O(N^2)
    */
    private int minFallingPathSumRec(int[][] grid, int rows, int cols) {

        for(int i=0;i<rows;++i){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int minSumFallingPath = Integer.MAX_VALUE;

        for(int j=0;j<cols;++j){
            minSumFallingPath = Math.min(
                    minSumFallingPath,
                    minFallingPathSumHelper(grid, rows, cols, 0, j)
            );
        }

        return minSumFallingPath;

    }

    private int minFallingPathSumHelper(int[][] grid, int rows, int cols, int row, int col){
        if(row == rows-1){
            return grid[row][col];
        }
        if(dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int nextPath = Integer.MAX_VALUE;
        for(int j=0;j<cols;++j){
            if(j!=col){
                nextPath = Math.min(
                        nextPath,
                        minFallingPathSumHelper(grid, rows, cols, row+1, j)
                );
            }
        }
        dp[row][col] = nextPath + grid[row][col];

        return dp[row][col];
    }
}
