package com.rohit.practice.leetcode.Array;

public class LT1608 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];

        for(int num : nums){
            if(num > n)
                count[n]++;
            else
                count[num]++;
        }

        int prevCount = 0;
        for(int i=n; i>=0; --i){
            count[i] += prevCount;

            if(i == count[i])
                return i;

            prevCount = count[i];
        }

        return -1;
    }
}
