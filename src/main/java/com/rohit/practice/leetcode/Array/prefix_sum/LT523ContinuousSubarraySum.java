package com.rohit.practice.leetcode.Array.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class LT523ContinuousSubarraySum {
    //Using prefix mod store to solve this in O(n).
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> modSeen = new HashMap<>();

        int curMod = 0;
        modSeen.put(curMod, -1);

        for(int i=0;i<n;++i){
            curMod = (curMod + nums[i]) % k;
            if(modSeen.containsKey(curMod)){
                if((i - modSeen.get(curMod)) > 1){
                    return true;
                }
            }else{
                modSeen.put(curMod, i);
            }
        }

        return false;
    }
    //O(n^2) solution with storing sum. Brute force solution is O(n^3).
    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];

        sum[0] = nums[0];
        int curSum = nums[0];
        for(int j=1;j<n;++j){
            curSum += nums[j];
            sum[j] = curSum;
            if(j>0 && curSum%k==0){
                return true;
            }
            int i = j-2;
            while(i>=0){
                if((sum[j] - sum[i]) % k == 0){
                    return true;
                }
                --i;
            }
        }

        return false;
    }
}
