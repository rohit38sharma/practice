package com.rohit.practice.leetcode.matrix;

public class LT861ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //Flip first column to make 1 if it is zero
        for(int i=0;i<m;++i){
            if(grid[i][0] == 0){
                for(int j=0;j<n;++j){
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        //Flip other column
        for(int j=1;j<n;++j){
            int countZero = 0;
            for(int i=0;i<m;++i){
                if(grid[i][j] == 0){
                    ++countZero;
                }
            }

            if(countZero > m-countZero){
                for(int i=0;i<m;++i){
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int score = 0;

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                score += (grid[i][j] << (n - j - 1));
            }
        }

        return score;
    }
}
