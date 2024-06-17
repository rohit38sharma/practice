package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LT679Game24 {
    public boolean judgePoint24(int[] cards) {
        List<Double> numbers = new ArrayList<>();

        for(int num : cards){
            numbers.add((double)num);
        }

        return judgePoint24Rec(numbers);
    }

    private boolean judgePoint24Rec(List<Double> numbers){
        if(numbers.size() == 1){
            if(Math.abs(numbers.get(0) - 24) <= 0.1){
                return true;
            }
            return false;
        }

        for(int i=0;i<numbers.size()-1;++i){
            for(int j=i+1;j<numbers.size();++j){
                List<Double> nextList = new ArrayList<>();

                for(int k=0;k<numbers.size();++k){
                    if(k!=i && k!=j){
                        nextList.add(numbers.get(k));
                    }
                }

                List<Double> possibleResultsofPair = generateAllPossibleResults(numbers.get(i), numbers.get(j));

                for(double res : possibleResultsofPair){
                    nextList.add(res);

                    if(judgePoint24Rec(nextList)){
                        return true;
                    }

                    nextList.remove(nextList.size()-1);
                }
            }
        }

        return false;
    }

    private List<Double> generateAllPossibleResults(double num1, double num2){
        List<Double> results = new ArrayList<>();
        results.add(num1 + num2);
        results.add(num1 - num2);
        results.add(num2 - num1);
        results.add(num1 * num2);
        if(num2 != 0){
            results.add(num1 / num2);
        }
        if(num1 != 0){
            results.add(num2 / num1);
        }

        return results;
    }
}
