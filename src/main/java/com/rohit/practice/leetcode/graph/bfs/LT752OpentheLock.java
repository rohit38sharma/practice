package com.rohit.practice.leetcode.graph.bfs;

import java.util.*;

public class LT752OpentheLock {
    private Map<Character, Character> prevSlot;
    private Map<Character, Character> nextSlot;
    private Set<String> visitedCombinations;
    private Queue<String> pendingCombinations;
    private final int wheels = 4;

    private void initialisation(String[] deadends){
        prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );

        nextSlot = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );

        visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        pendingCombinations = new LinkedList<>();
    }

    public int openLock(String[] deadends, String target) {
        //initialisation
        initialisation(deadends);

        //Check if source is already present in DeadEnds
        if(visitedCombinations.contains("0000"))
            return -1;

        //Find shortest path from source to target.
        return findShortestPath(target);

    }

    private int findShortestPath(String target){
        int turns = 0;
        pendingCombinations.offer("0000");

        while(!pendingCombinations.isEmpty()){
            int size = pendingCombinations.size();

            for(int i=1;i<=size;++i){
                String cur = pendingCombinations.remove();

                if(target.equals(cur))
                    return turns;

                char[] curCombination = cur.toCharArray();

                for(int w=0;w<wheels;++w){
                    //Previous Turn
                    curCombination[w] = prevSlot.get(cur.charAt(w));
                    validateAndAddCombination(new String(curCombination));

                    //Next Turn
                    curCombination[w] = nextSlot.get(cur.charAt(w));
                    validateAndAddCombination(new String(curCombination));

                    //Resetting Current Wheel
                    curCombination[w] = cur.charAt(w);
                }
            }

            ++turns;
        }

        return -1;
    }

    private void validateAndAddCombination(String combination){
        if(!visitedCombinations.contains(combination)){
            visitedCombinations.add(combination);
            pendingCombinations.offer(combination);
        }
    }
}
