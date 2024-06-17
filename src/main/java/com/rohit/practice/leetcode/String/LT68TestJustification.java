package com.rohit.practice.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class LT68TestJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        int s=0,e=0;

        List<String> res = new ArrayList<>();

        while(e<n){
            StringBuilder sb = new StringBuilder();
            int len = words[e].length();
            int t;
            while(e+1<n && ((t=(len+words[e+1].length()))+e+1-s) <= maxWidth){
                ++e;
                len = t;
            }

            int count = Math.max(e-s,1);
            int diff = (maxWidth - len);
            int div = diff / count;
            int mod = diff % count;

            boolean lastLine = (e>=n-1);
            String[] temp = new String[e-s+1];
            for(int i=e;i>=s;--i){
                StringBuilder word = new StringBuilder();
                word.append(words[i]);
                if(lastLine){
                    if(i==e){
                        word.append(spaces(diff-(e-s)));
                    }else{
                        word.append(" ");
                    }
                }else{
                    if(i==s){
                        word.append(spaces(div+mod));
                    }else if(i<e){
                        word.append(spaces(div));
                        diff -= div;
                        div = diff / (i-s);
                        mod = diff % (i-s);
                    }
                }

                temp[i-s] = word.toString();
            }

            for(int i=s;i<=e;++i){
                sb.append(temp[i-s]);
            }

            ++e;
            s = e;

            res.add(sb.toString());
        }

        return res;
    }

    private String spaces(int len){
        return " ".repeat(Math.max(0, len));
    }
}
