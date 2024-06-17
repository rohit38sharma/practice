package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT40CombinationSumII {
    private List<List<Integer>> res;
    private List<Integer> cur;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0);
        return res;
    }

    private void findCombinations(int[] candidates, int target, int i){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int k=i;k<candidates.length;++k){
            if(candidates[k] > target)
                break;
            if(k>i && candidates[k]==candidates[k-1])
                continue;
            cur.add(candidates[k]);
            findCombinations(candidates, target - candidates[k], k+1);
            cur.remove(cur.size()-1);
        }



        /*if(i>=n || target<candidates[i])
            return;
        //With current element
        cur.add(candidates[i]);
        findCombinations(candidates, target - candidates[i], i+1, n, cur);

        //Without current element
        cur.remove(cur.size()-1);
        int k=1;
        while(i+k < n && candidates[i+k] == candidates[i]){
            ++k;
        }
        findCombinations(candidates, target, i+k, n, cur);*/
    }
}
