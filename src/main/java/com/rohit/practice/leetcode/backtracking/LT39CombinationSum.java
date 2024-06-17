package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LT39CombinationSum {
    private List<List<Integer>> combinationList;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationList = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return combinationList;
    }

    private void helper(int[] candidates, int target, int i, ArrayList<Integer> path){
        if(target == 0){
            combinationList.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path);
        path.remove(path.size()-1);
        helper(candidates, target, i+1, path);
    }
}
