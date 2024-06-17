package com.rohit.practice.leetcode.Array;

import java.util.HashMap;
import java.util.Stack;

public class LT402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k)
            return "0";
        char[] inp = num.toCharArray();
        int i=0;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            int cur = inp[i] - '0';
            while(!st.isEmpty() && cur<st.peek() && k>0){
                st.pop();
                --k;
            }
            if(!st.isEmpty() || cur>0)
                st.push(cur);
            ++i;
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            --k;
        }
        if(st.isEmpty())
            return "0";

        char[] ans = new char[st.size()];
        int idx = st.size()-1;
        while(!st.isEmpty()){
            ans[idx] = (char)(st.pop() + '0');
            --idx;
        }

        return new String(ans);

    }
}
