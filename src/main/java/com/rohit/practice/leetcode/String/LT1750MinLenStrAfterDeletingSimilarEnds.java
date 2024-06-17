package com.rohit.practice.leetcode.String;

public class LT1750MinLenStrAfterDeletingSimilarEnds {
    public static int minimumLength(String s) {
        int n = s.length();
        char[] carr = s.toCharArray();
        if(n<=1)
            return n;
        int i=0, j=n-1;
        while(i<j && carr[i]==carr[j]){
            char c = carr[i];
            ++i;
            while(i<j && carr[i]==c){
                ++i;
            }
            --j;
            while(i<j && carr[j]==c){
                --j;
            }
        }

        return j-i+1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("ca"));
    }
}
