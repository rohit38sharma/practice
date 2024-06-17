package com.rohit.practice.leetcode.Array;

public class LT713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1;
        int s=0, e=0;
        int n = nums.length;
        while(e<n){
            prod *= nums[e];
            while(prod>=k && s<=e){
                prod /= nums[s];
                ++s;
            }

            res += (e-s+1);
            ++e;
        }

        return res;
    }
}
