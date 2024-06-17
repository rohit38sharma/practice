package com.rohit.practice.leetcode.greedy;

public class LT3068FindMaximumSumNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;

        long totalSum = 0;
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        long posSum = 0;
        int posCount = 0;

        for(int i=0; i<n; ++i){
            int xorVal = nums[i] ^ k;
            int d = xorVal - nums[i];
            totalSum += nums[i];

            if(d >= 0){
                posSum += d;
                minPos = Math.min(minPos, d);
                ++posCount;
            }else{
                maxNeg = Math.max(maxNeg, d);
            }
        }

        //Sorting approach
        //Arrays.sort(delta, Collections.reverseOrder());
        /*for(int i=0;i<n-1;i+=2){
            long sum = delta[i] + delta[i+1];
            if(sum <= 0)
                break;
            totalSum += sum;
        }*/

        if(posCount % 2 != 0){
            posSum -= minPos;
            posSum = Math.max(posSum, posSum + minPos + maxNeg);
        }

        totalSum += posSum;

        return totalSum;
    }
}
