package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT90SubsetsII {
    private List<List<Integer>> subsetList;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsetList = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), nums.length);
        return subsetList;
    }

    private void helper(int[] nums, int i, ArrayList<Integer> path, int n){
        if(i >= n){
            subsetList.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        helper(nums, i+1, path, n);
        path.remove(path.size()-1);
        ++i;
        while(i<n && nums[i]==nums[i-1]){
            ++i;
        }
        helper(nums, i, path, n);
    }
}
