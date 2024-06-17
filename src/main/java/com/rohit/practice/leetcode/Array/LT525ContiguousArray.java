package com.rohit.practice.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class LT525ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        Map<Integer,Integer> count = new HashMap<>();
        count.put(0,-1);

        int sum = 0;

        for(int i=0;i<nums.length;++i){
            sum += nums[i] * 2 - 1;
            if(count.containsKey(sum)){
                max = Math.max(max, (i - count.get(sum)));
            }else{
                count.put(sum,i);
            }
        }

        return max;
    }
}
