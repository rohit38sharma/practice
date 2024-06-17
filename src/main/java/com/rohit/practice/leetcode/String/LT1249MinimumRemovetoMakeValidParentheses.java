package com.rohit.practice.leetcode.String;

import java.util.Stack;

public class LT1249MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<String> st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(sb.toString());
                sb = new StringBuilder();
            }else if(c == ')'){
                if(!st.isEmpty()){
                    StringBuilder temp = new StringBuilder();
                    temp.append(st.pop());
                    temp.append('(');
                    temp.append(sb.toString());
                    temp.append(')');
                    sb = temp;
                }
            }else{
                sb.append(c);
            }
        }
        while(!st.isEmpty()){
            StringBuilder temp = new StringBuilder();
            temp.append(st.pop());
            temp.append(sb.toString());
            sb = temp;
        }

        return sb.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        int n = s.length();
        if(n==0)
            return s;
        Stack<String> st = new Stack<>();

        //StringBuilder sb = new StringBuilder();

        String validStr = "";

        String temp = "";

        for(int i=0;i<n;++i){
            char c = s.charAt(i);
            if(c == '('){
                st.push(temp);
                temp = "";
            }else if(c == ')'){
                if(!st.isEmpty()){
                    temp = st.pop() + "(" + temp + ")";
                }
            }else{
                temp = temp + c;
            }
        }

        while(!st.isEmpty()){
            temp = st.pop() + temp;
        }

        return temp;
    }
}
