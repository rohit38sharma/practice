package com.rohit.practice.leetcode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LT939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        int n = points.length;

        Map<Integer, Set<Integer>> pointSet = new HashMap<>();

        for(int[] p : points){
            pointSet.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for(int i=0;i<n-1;++i){
            for(int j=i+1;j<n;++j){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 || y1 == y2 || Math.abs(x1-x2) * Math.abs(y1-y2) >= minArea)
                    continue;

                if(pointSet.get(x1).contains(y2) && pointSet.get(x2).contains(y1)){
                    minArea = Math.min(minArea, Math.abs(x1-x2) * Math.abs(y1-y2));
                }
            }
        }


        return minArea == Integer.MAX_VALUE ?0 :minArea;
    }
}
