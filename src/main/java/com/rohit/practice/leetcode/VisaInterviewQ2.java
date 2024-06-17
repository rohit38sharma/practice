package com.rohit.practice.leetcode;

public class VisaInterviewQ2 {
    public static int findMaxSafePath(int numRows, int numCols, int curRow, int curCol, int[][] lasers){
        int left_j=0, right_j=numCols-1, up_i=0, down_i=numRows-1;
        for(int i=0;i<lasers.length;++i){
            int[] laser = lasers[i];
            if(laser[0] <= curRow){
                up_i = Math.max(up_i, laser[0]);
            }
            if(laser[0] >= curRow){
                down_i = Math.min(down_i, laser[0]);
            }
            if(laser[1] <= curCol){
                left_j = Math.max(left_j, laser[1]);
            }
            if(laser[1] >= curCol){
                right_j = Math.min(right_j, laser[1]);
            }
        }

        int left = curCol - left_j;
        int right = right_j - curCol;
        int up = curRow - up_i;
        int down = down_i - curRow;

        return Math.max(Math.max(left, right), Math.max(up,down));

    }

    public static void main(String[] args) {
        int[][] lasers = {{1,6},{2,8}};
        int ans = findMaxSafePath(8, 8, 5, 3, lasers);
        System.out.println(ans);
    }
}
