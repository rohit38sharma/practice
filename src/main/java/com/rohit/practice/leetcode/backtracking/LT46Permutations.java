package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LT46Permutations {
    private boolean[] visited;
    private List<List<Integer>> permutatios;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        permutatios = new ArrayList<>();
        helper(nums, new ArrayList<>());

        return permutatios;
    }

    private void helper(int[] nums, ArrayList<Integer> path){
        if(path.size() == nums.length){
            permutatios.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; ++i){
            if(!visited[i]){
                visited[i] = true;
                path.add(nums[i]);
                helper(nums, path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
