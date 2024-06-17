package com.rohit.practice.leetcode.Array;

public class LT2073TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int n = tickets.length;

        for(int i=0;i<n;++i){
            if(i<=k){
                time += Math.min(tickets[k], tickets[i]);
            }else{
                time += Math.min(tickets[k]-1, tickets[i]);
            }
        }

        return time;
    }
}
