package com.rohit.practice.leetcode.String;

import java.util.Stack;

public class LT32LongestValidParentheses {
    //O(N) time and O(1) space
    public int longestValidParentheses(String s) {
        int maxValid = 0;
        int open=0, close=0;
        int len=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == '('){
                ++open;
            }else{
                ++close;
            }

            if(open==close){
                len = open + close;
                maxValid = Math.max(maxValid, len);
            }
            if(close > open){
                open = close = 0;
            }
        }

        open = close = 0;

        for(int i=s.length()-1;i>=0;--i){
            if(s.charAt(i) == '('){
                ++open;
            }else{
                ++close;
            }

            if(open==close){
                len = open + close;
                maxValid = Math.max(maxValid, len);
            }
            if(open > close){
                open = close = 0;
            }
        }

        return maxValid;
    }

    //O(N) time and O(N) space
    public int longestValidParentheses_old(String s) {
        int maxValid = 0;
        int curValid = 0;
        Stack<Integer> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(curValid);
                curValid = 0;
            }
            else{
                if(st.isEmpty()){
                    curValid = 0;
                }else{
                    curValid += (st.pop() + 2);
                    maxValid = Math.max(maxValid, curValid);
                }
            }
        }

        return maxValid;
    }
}
