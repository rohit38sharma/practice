package com.rohit.practice.leetcode.Array;

import java.util.Stack;

public class LT84LargestRectangleInHistogram {
    private class Histo{
        int idx;
        int h;

        public Histo(int idx, int h){
            this.idx = idx;
            this.h = h;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Histo> st = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<n;++i){
            int back = i;
            while(!st.isEmpty() && heights[i] < st.peek().h){
                Histo last = st.pop();
                maxArea = Math.max(maxArea, last.h * (i - last.idx));
                back = last.idx;
            }
            st.push(new Histo(back, heights[i]));
        }

        while(!st.isEmpty()){
            Histo last = st.pop();
            maxArea = Math.max(maxArea, last.h * (n - last.idx));
        }

        return maxArea;
    }
}
