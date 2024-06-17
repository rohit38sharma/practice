package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LT131PalindromePartitioning {
    private List<List<String>> palindromes;
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        int n = s.length();
        palindromes = new ArrayList<>();
        dp = new boolean[n][n];
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                /*if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }*/
                dp[i][j] = isPalindrome(s, i, j);
            }
        }
        helper(s, 0, new ArrayList<>());
        return palindromes;
    }

    private void helper(String s, int idx, ArrayList<String> collector){
        if(idx == s.length()){
            palindromes.add(new ArrayList<>(collector));
            return;
        }
        for(int i=idx;i<s.length();++i){
            //isPalindrome(s, idx, i)
            if(dp[idx][i]){
                collector.add(s.substring(idx,i+1));
                helper(s, i+1, collector);
                collector.remove(collector.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            ++start;
            --end;
        }

        return true;
    }
}
