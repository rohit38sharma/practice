package com.rohit.practice.leetcode.String;

import java.util.Stack;

public class LT394DecodeString {
    public String decodeString(String s) {
        Stack<Integer> timesStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curString = new StringBuilder();
        int curTimes = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                curTimes = (curTimes * 10) + (c - '0');
            }else if(c == '['){
                timesStack.push(curTimes);
                stringStack.push(curString);

                curString = new StringBuilder();
                curTimes = 0;
            }else if(c == ']'){
                int times = timesStack.pop();
                StringBuilder prevString = stringStack.pop();

                while(times > 0){
                    prevString.append(curString);
                    --times;
                }

                curString = prevString;
            }else{
                curString.append(c);
            }
        }

        return curString.toString();
    }
}
