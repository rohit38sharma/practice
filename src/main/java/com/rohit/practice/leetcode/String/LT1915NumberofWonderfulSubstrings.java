package com.rohit.practice.leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class LT1915NumberofWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long res = 0;
        int bitMask = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for(char c : word.toCharArray()){
            int char_bit = c - 'a';
            bitMask ^= (1 << char_bit);

            //Prefix having no odd character
            res += freq.getOrDefault(bitMask, 0);

            //Prefix having only one odd character. Checking for each char from a to j
            for(int i=0; i<10; ++i){
                res += freq.getOrDefault(bitMask ^ (1 << i), 0);
            }

            freq.put(bitMask, freq.getOrDefault(bitMask, 0) + 1);
        }

        return res;

    }
}
