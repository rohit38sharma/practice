package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LT78Subsets {
    private List<List<Integer>> subsetList;

    public List<List<Integer>> subsets(int[] nums) {
        subsetList = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return subsetList;
    }

    private void helper(int[] nums, int i, ArrayList<Integer> path){
        if(i >= nums.length){
            List<Integer> copy = new ArrayList<>(path);
            subsetList.add(copy);
            return;
        }
        helper(nums, i+1, path);
        path.add(nums[i]);
        helper(nums, i+1, path);
        path.remove(path.size()-1);
    }
}
