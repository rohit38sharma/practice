package com.rohit.practice.leetcode.dp;

import java.util.Arrays;

public class LT2370LongestIdealSubsequence {
    private int[] dp;

    public int longestIdealString(String s, int k) {
        int n = s.length();
        if(n<=1)
            return n;

        dp = new int[26];

        int longestseqlen = 0;

        for(int i=n-1; i>=0; --i){
            int charidx = s.charAt(i) - 'a';
            int curMax = 1;
            for(int j=0;j<=k;++j){
                if(charidx + j < 26){
                    curMax = Math.max(curMax, dp[charidx + j] + 1);
                }
                if(charidx - j >= 0){
                    curMax = Math.max(curMax, dp[charidx - j] + 1);
                }
            }
            dp[charidx] = Math.max(dp[charidx], curMax);
            longestseqlen = Math.max(longestseqlen, curMax);
        }

        return longestseqlen;
    }

    public int longestIdealStringDp(String s, int k) {
        int n = s.length();
        if(n<=1)
            return n;

        dp = new int[n];
        Arrays.fill(dp, 1);

        int longestseqlen = 1;

        for(int i=n-2; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                if(Math.abs(s.charAt(i) - s.charAt(j)) <= k){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longestseqlen = Math.max(longestseqlen, dp[i]);
        }

        return longestseqlen;

    }

    public int longestIdealStringRec(String s, int k) {
        int n = s.length();
        dp = new int[n];

        int longestSeq = 0;
        for(int i=n-1;i>=0;--i){
            longestSeq = Math.max(longestSeq, longestIdealStringHelper(s, k, i, n));
        }
        return longestSeq;
    }

    private int longestIdealStringHelper(String s, int k, int curIdx, int n){
        if(curIdx >= n)
            return 0;

        if(dp[curIdx] > 0)
            return dp[curIdx];

        for(int i=curIdx+1; i<n; ++i){
            if(Math.abs(s.charAt(curIdx) - s.charAt(i)) <= k){
                dp[curIdx] = Math.max(dp[curIdx],
                        longestIdealStringHelper(s, k, i, n));
            }
        }

        dp[curIdx]++;

        return dp[curIdx];
    }
}
