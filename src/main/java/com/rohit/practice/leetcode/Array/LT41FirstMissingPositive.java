package com.rohit.practice.leetcode.Array;

public class LT41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;++i){
            if(nums[i]<0 || nums[i]>n)
                nums[i] = 0;
        }

        for(int i=0;i<n;++i){
            int num = Math.abs(nums[i]);
            if(num>0 && num<=n){
                int cur = nums[num-1];
                int upd = cur==0 ?(n+1) :Math.abs(cur);
                nums[num-1] = upd * -1;
            }
        }

        for(int i=0;i<n;++i){
            if(nums[i]>=0)
                return i+1;
        }

        return n+1;
    }
}
