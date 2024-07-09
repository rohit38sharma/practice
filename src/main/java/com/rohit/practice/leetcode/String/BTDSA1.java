package com.rohit.practice.leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BTDSA1 {

    private static boolean checkAnagram(String s1, String s2, String s3){

        char[] s1_c = s1.toCharArray();
        char[] s2_c = s2.toCharArray();
        char[] s3_c = s3.toCharArray();


        if(s1_c.length != s2_c.length || s1_c.length != s3_c.length){
            return false;
        }

        Arrays.sort(s1_c);
        Arrays.sort(s2_c);
        Arrays.sort(s3_c);

        for(int i=0;i<s1_c.length;++i){
            if(s1_c[i] != s2_c[i] || s1_c[i] != s3_c[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("bbac", "abcb", "acbb"));
    }
}
