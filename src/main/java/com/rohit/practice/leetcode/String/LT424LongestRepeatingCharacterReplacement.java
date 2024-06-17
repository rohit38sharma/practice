package com.rohit.practice.leetcode.String;

public class LT424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];

        int l = 0, r = 0;
        int lonsubstring = 0;

        int maxFreq = 0;

        while(r < n){

            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            int len = r - l + 1;

            while(l < r && len - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                ++l;
                len = r - l + 1;
            }

            lonsubstring = Math.max(lonsubstring, len);
            ++r;
        }

        return lonsubstring;
    }
}
