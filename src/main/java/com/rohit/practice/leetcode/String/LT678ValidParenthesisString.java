package com.rohit.practice.leetcode.String;

import java.util.Stack;

public class LT678ValidParenthesisString {
    //Two pointer Approach: Time-O(n), Space-O(1)
    public boolean checkValidString(String s) {
        int open=0, close=0;
        int n = s.length();

        for(int i=0;i<n;++i){
            if(s.charAt(i) == '(' || s.charAt(i) == '*')
                ++open;
            else if(s.charAt(i) == ')')
                --open;

            if(s.charAt(n-i-1) == ')' || s.charAt(n-i-1) == '*')
                ++close;
            else if(s.charAt(n-i-1) == '(')
                --close;
            if(open<0 || close<0)
                return false;
        }

        return true;
    }

    //Greedy Approach: Time-O(n), Space-O(n)
    public boolean checkValidString3(String s) {
        int n = s.length();
        Stack<Integer> open = new Stack<>();
        Stack<Integer> ast = new Stack<>();

        for(int i=0;i<n;++i){
            if(s.charAt(i) == '('){
                open.push(i);
            }else if(s.charAt(i) == '*'){
                ast.push(i);
            }else{
                if(!open.isEmpty())
                    open.pop();
                else if(!ast.isEmpty())
                    ast.pop();
                else
                    return false;
            }
        }

        while(!open.isEmpty() && !ast.isEmpty()){
            if(open.pop() > ast.pop())
                return false;
        }

        return open.isEmpty();
    }

    //Bottom-Up Dynamic Programming - Tabulation: Time-O(n^2), Space-O(n^2)
    public boolean checkValidString2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        dp[n][0] = true;
        for(int i=n-1;i>=0;--i){
            for(int j=0;j<n;++j){
                if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                    dp[i][j] |= dp[i+1][j+1];
                }
                if(j>0 && (s.charAt(i)==')' || s.charAt(i)=='*')){
                    dp[i][j] |= dp[i+1][j-1];
                }
                if(s.charAt(i)=='*'){
                    dp[i][j] |= dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

    //Top-Down Dynamic Programming - Memoization: Time-O(n^2), Space-O(n^2)
    public boolean checkValidString1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n+1];
        int res = helper(s, 0, 0, dp);
        return res==1;
    }

    private int helper(String s, int i, int opens, int[][] dp){
        if(i >= s.length()){
            return opens==0 ?1 :-1;
        }
        if(opens<0)
            return -1;
        if(dp[i][opens]!=0)
            return dp[i][opens];
        dp[i][opens] = -1;
        if(s.charAt(i)=='(' || s.charAt(i)=='*'){
            dp[i][opens] = Math.max(helper(s, i+1, opens+1, dp), dp[i][opens]);
        }
        if(s.charAt(i)==')' || s.charAt(i)=='*'){
            dp[i][opens] = Math.max(helper(s, i+1, opens-1, dp), dp[i][opens]);
        }
        if(s.charAt(i)=='*'){
            dp[i][opens] = Math.max(helper(s, i+1, opens, dp), dp[i][opens]);
        }
        return dp[i][opens];
    }
}
