package com.rohit.practice.leetcode.greedy;

public class LT2139MinMovestoReachTarget {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0){
            return target-1;
        }

        int moves = 0;
        while(target > 1){
            if(maxDoubles == 0){
                moves += (target-1);
                break;
            }
            if(maxDoubles > 0 && target % 2 == 0){
                target /= 2;
                --maxDoubles;
            }else{
                --target;
            }
            ++moves;
        }

        return moves;
    }
}
