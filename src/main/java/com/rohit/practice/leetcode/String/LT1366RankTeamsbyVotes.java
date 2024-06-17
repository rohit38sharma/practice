package com.rohit.practice.leetcode.String;

import java.util.*;

public class LT1366RankTeamsbyVotes {
    public String rankTeams(String[] votes) {
        int n = votes.length;
        if(n == 1){
            return votes[0];
        }

        int pos = votes[0].length();
        Map<Character, int[]> rankForTeam = new HashMap<>();

        for(String vote : votes){
            for(int i=0;i<vote.length();++i){
                char team = vote.charAt(i);
                if(!rankForTeam.containsKey(team)){
                    rankForTeam.put(team, new int[pos]);
                }
                rankForTeam.get(team)[i] += 1;
            }
        }

        List<Character> teams = new ArrayList<>(rankForTeam.keySet());
        Collections.sort(
                teams,
                (a,b) -> {
                    for(int i=0;i<pos;++i){
                        int rank_a = rankForTeam.get(a)[i];
                        int rank_b = rankForTeam.get(b)[i];
                        if(rank_a != rank_b){
                            return rank_b - rank_a;
                        }
                    }

                    return a - b;
                }
        );

        StringBuilder sb = new StringBuilder();
        for(char c : teams){
            sb.append(c);
        }

        return sb.toString();
    }
}
