package com.rohit.practice.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class LT442FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] < 0)
                duplicates.add(idx);
            else
                nums[idx-1] *= -1;
        }

        return duplicates;
    }
}
