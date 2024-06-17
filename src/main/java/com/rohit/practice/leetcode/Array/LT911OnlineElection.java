package com.rohit.practice.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class LT911OnlineElection {
    private Map<Integer, Integer> leadingAtTime;
    private int[] timeline;
    private int n;

    public LT911OnlineElection(int[] persons, int[] times) {
        n = times.length;
        leadingAtTime = new HashMap<>();
        timeline = new int[n];

        countVotes(persons, times);
    }

    private void countVotes(int[] persons, int[] times){
        int maxVotes = 0;
        int leader = 0;
        Map<Integer, Integer> voteCount = new HashMap<>();

        for(int i=0;i<n;++i){
            int curVote = voteCount.getOrDefault(persons[i], 0) + 1;
            voteCount.put(persons[i], curVote);

            if(curVote >= maxVotes){
                maxVotes = curVote;
                leader = persons[i];
            }

            leadingAtTime.put(times[i], leader);
            timeline[i] = times[i];
        }
    }

    public int q(int t) {
        int time = findActualTime(t);
        return leadingAtTime.get(time);
    }

    private int findActualTime(int t){
        int s=0, e=n-1, mid;

        while(s < e){
            if(e - s == 1){
                return timeline[e]>t ?timeline[s] :timeline[e];
            }
            mid = s + ((e - s)/2);
            if(timeline[mid] == t){
                return timeline[mid];
            }else if(timeline[mid] > t){
                e = mid;
            }else{
                s = mid;
            }
        }

        return timeline[s];
    }
}
