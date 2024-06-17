package com.rohit.practice.leetcode.Array;

import java.util.Arrays;

public class LT881BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int[] count = new int[limit+1];
        for(int w : people){
            count[w]++;
        }

        int l = 1, r = limit;
        int numBoats = 0;
        while(l <= r){
            while(l<=r && count[l]<=0){
                ++l;
            }
            while(l<=r && count[r]<=0){
                --r;
            }

            if(count[l] <= 0 && count[r]<=0){
                break;
            }

            if(l + r <= limit){
                --count[l];
            }
            --count[r];
            ++numBoats;
        }

        return numBoats;
    }
    public int numRescueBoats1(int[] people, int limit) {
        int n = people.length;
        if(n<=1)
            return n;
        Arrays.sort(people);

        int numBoats = 0;
        int l=0, r=n-1;
        while(l <= r){
            if(people[l] + people[r] <= limit){
                ++l;
            }
            --r;
            ++numBoats;
        }

        return numBoats;
    }
}
