package com.rohit.practice.leetcode.bitmanipulation;

public class LT2997MinNumofOperationsNeedforXOREqualK {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int xor = nums[0];

        for(int i=1;i<n;++i){
            xor ^= nums[i];
        }

        int minOperations = 0;

        while(xor != k){
            if((xor & 1) != (k & 1)){
                ++minOperations;
            }

            xor = xor >> 1;
            k = k >> 1;
        }

        return minOperations;
    }
}
