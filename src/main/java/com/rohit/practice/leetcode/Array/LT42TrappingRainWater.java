package com.rohit.practice.leetcode.Array;

public class LT42TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int trapWaterSum = 0, curheight, step, idx;
        while(l<r){
            if(height[l] < height[r]){
                curheight = height[l];
                step = 1;
                idx = l+1;
            }else{
                curheight = height[r];
                step = -1;
                idx = r-1;
            }

            while(idx>l && idx<r && height[idx]<=curheight){
                trapWaterSum += (curheight - height[idx]);
                idx += step;
            }
            if(step == 1)
                l = idx;
            else
                r = idx;
        }

        return trapWaterSum;
    }
    public int trap1(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int max = -1;

        for(int i=n-1;i>=0;--i){
            if(height[i] < max){
                rightMax[i] = max;
            }else{
                rightMax[i] = -1;
                max = height[i];
            }
        }

        int maxWater = 0;
        int curMax = height[0];
        for(int i=1;i<n;++i){
            if(curMax > height[i]){
                if(rightMax[i]>-1)
                    maxWater += (Math.min(curMax, rightMax[i]) - height[i]);
            }else{
                curMax = height[i];
            }
        }

        return maxWater;
    }
}
