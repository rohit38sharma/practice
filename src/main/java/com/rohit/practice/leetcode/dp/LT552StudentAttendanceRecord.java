package com.rohit.practice.leetcode.dp;

public class LT552StudentAttendanceRecord {
    private int[][][] dp;
    private int MOD = 1000000007;
    public int checkRecord(int n) {

        //Days - Absent - Late
        dp = new int[n+1][2][3];

        for(int i=0;i<=n;++i){
            for(int j=0;j<2;++j){
                for(int k=0;k<3;++k){
                    dp[i][j][k] = -1;
                }
            }
        }

        return checkRecordRec(n, 0, 0);
    }

    private int checkRecordRec(int n, int l_cnt, int a_cnt){
        if(n==0 || l_cnt >= 3 || a_cnt >= 2){
            return 0;
        }

        if(n==1){
            int count = 1;
            if(l_cnt < 2)
                count++;
            if(a_cnt < 1)
                count++;
            return count;
        }

        if(dp[n][a_cnt][l_cnt] != -1){
            return dp[n][a_cnt][l_cnt];
        }

        //Present
        int count = (checkRecordRec(n-1, 0, a_cnt)) % MOD;

        //Absent
        count = (count + checkRecordRec(n-1, 0, a_cnt+1)) % MOD;

        //Late
        count = (count + checkRecordRec(n-1, l_cnt+1, a_cnt)) % MOD;

        dp[n][a_cnt][l_cnt] = count;

        return count;
    }
}
