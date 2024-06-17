package com.rohit.practice.leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LT1048LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;

        if(n <= 1){
            return n;
        }

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> wordSuccCount = new HashMap<>();

        int maxWordChain = 0;

        for(String word : words){
            int maxLen = 1;
            for(int i=0; i<word.length(); ++i){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String predecessor = sb.toString();
                if(wordSuccCount.containsKey(predecessor)){
                    maxLen = Math.max(maxLen, wordSuccCount.get(predecessor) + 1);
                }
            }

            wordSuccCount.put(word, maxLen);
            maxWordChain = Math.max(maxWordChain, maxLen);
        }

        return maxWordChain;
    }
}
