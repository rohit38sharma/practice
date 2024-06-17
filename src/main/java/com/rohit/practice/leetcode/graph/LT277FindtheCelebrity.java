package com.rohit.practice.leetcode.graph;

public class LT277FindtheCelebrity {
    //3n calls approach
    public int findCelebrity(int n) {
        int potCel = 0;
        for(int i=1;i<n;++i){
            if(knows(potCel, i)){
                potCel = i;
            }
        }

        for(int i=0;i<n;++i){
            if(i!=potCel && (!knows(i, potCel) || knows(potCel, i))){
                return -1;
            }
        }

        return potCel;
    }



    //Brute Force approch : Use n^2 api calls
    public int findCelebrity1(int n) {
        for(int i=0;i<n;++i){
            if(isCelibrity(i, n)){
                return i;
            }
        }

        return -1;
    }

    private boolean isCelibrity(int i, int n){
        for(int j=0;j<n;++j){
            if(i!=j && (knows(i, j) || !knows(j, i)))
                return false;
        }
        return true;
    }

    private boolean knows(int i, int j){
        return true;
    }
}
