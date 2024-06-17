package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT17LetterCombinationsofaPhoneNumber {
    private List<String> combinations;
    private Map<Character, String> map;

    public LT17LetterCombinationsofaPhoneNumber(){
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if(digits.length() == 0)
            return combinations;
        helper(digits, 0, new StringBuilder());
        return combinations;
    }

    private void helper(String digits, int idx, StringBuilder sb){
        if(idx >= digits.length()){
            combinations.add(sb.toString());
            return;
        }
        String cur = map.get(digits.charAt(idx));
        for(char c : cur.toCharArray()){
            sb.append(c);
            helper(digits, idx+1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}
