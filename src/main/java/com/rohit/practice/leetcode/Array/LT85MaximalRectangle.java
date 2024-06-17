package com.rohit.practice.leetcode.Array;

import java.util.Stack;

public class LT85MaximalRectangle {
    private class Histo{
        int idx;
        int h;

        public Histo(int idx, int h){
            this.idx = idx;
            this.h = h;
        }
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] singleRow = new int[cols];
        int maxArea = 0;

        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(matrix[i][j] == '0')
                    singleRow[j] = 0;
                else
                    singleRow[j] += 1;
            }

            Stack<Histo> st = new Stack<>();

            for(int k=0;k<cols;++k){
                int back = k;
                while(!st.isEmpty() && singleRow[k] < st.peek().h){
                    Histo last = st.pop();
                    maxArea = Math.max(maxArea, last.h * (k - last.idx));
                    back = last.idx;
                }
                st.push(new Histo(back, singleRow[k]));
            }

            while(!st.isEmpty()){
                Histo last = st.pop();
                maxArea = Math.max(maxArea, last.h * (cols - last.idx));
            }
        }

        return maxArea;
    }
}
