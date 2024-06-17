package com.rohit.practice.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class LT722RemoveComments {
    public List<String> removeComments(String[] source) {
        boolean blockComment = false;

        List<String> code = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String line : source){
            int len = line.length();
            for(int i=0;i<len;++i){
                if(line.charAt(i) == '/' && i+1<len && line.charAt(i+1) == '/' && !blockComment){
                    break;
                }
                if(line.charAt(i) == '/' && i+1<len && line.charAt(i+1) == '*' && !blockComment){
                    blockComment = true;
                    ++i;
                    continue;
                }
                if(line.charAt(i) == '*' && i+1<len && line.charAt(i+1) == '/' && blockComment){
                    blockComment = false;
                    ++i;
                    continue;
                }
                if(!blockComment){
                    sb.append(line.charAt(i));
                }
            }

            if(sb.length() > 0 && !blockComment){
                code.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        if(sb.length() > 0){
            code.add(sb.toString());
        }

        return code;
    }
}
