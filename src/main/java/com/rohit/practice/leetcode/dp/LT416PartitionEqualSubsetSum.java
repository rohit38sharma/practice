package com.rohit.practice.leetcode.dp;

public class LT416PartitionEqualSubsetSum {
    private Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int e : nums){
            sum += e;
        }

        if(sum % 2 == 1)
            return false;

        sum /= 2;
        dp = new Boolean[nums.length+1][sum+1];

        return canPartitionHelper(nums, 0, sum);
    }

    private boolean canPartitionHelper(int[] nums, int idx, int sum){
        if(sum == 0)
            return true;

        if(idx >= nums.length || sum < 0)
            return false;

        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }

        //Include
        boolean withCur = canPartitionHelper(nums, idx + 1, sum - nums[idx]);
        //not include
        boolean withoutCur = canPartitionHelper(nums, idx + 1, sum);

        return dp[idx][sum] = (withCur || withoutCur);
    }
}
