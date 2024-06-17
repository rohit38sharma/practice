package com.rohit.practice.leetcode.graph.dijkstras;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LT1631PathWithMinimumEffort {
    private class Node{
        int i;
        int j;
        int effort;

        public Node(int i, int j, int effort){
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }


    public int minimumEffortPath(int[][] heights) {
        return dijkstraSolution(heights);
    }

    private int dijkstraSolution(int[][] heights){
        int row = heights.length;
        int col = heights[0].length;
        int[][] minEffort = new int[row][col];

        for(int[] e : minEffort){
            Arrays.fill(e, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        minEffort[0][0] = 0;
        pq.offer(new Node(0,0,0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Node cur = pq.remove();
            int r = cur.i;
            int c = cur.j;
            int d = cur.effort;

            if(r == row-1 && c == col-1){
                return d;
            }

            for(int i=0;i<4;++i){
                int nxtR = r + dr[i];
                int nxtC = c + dc[i];

                if(nxtR >= 0 && nxtR < row && nxtC >= 0 && nxtC < col){
                    int eff = Math.max(d, Math.abs(heights[r][c] - heights[nxtR][nxtC]));
                    if(eff < minEffort[nxtR][nxtC]){
                        minEffort[nxtR][nxtC] = eff;
                        pq.offer(new Node(nxtR, nxtC, eff));
                    }
                }
            }

            /*if(cur.i-1>=0 && !visited[cur.i-1][cur.j]){
                int diff = Math.abs(cur_h - heights[cur.i-1][cur.j]);
                pq.offer(new Node(cur.i-1, cur.j, Math.max(cur.effort, diff)));
            }
            if(cur.i+1<row && !visited[cur.i+1][cur.j]){
                int diff = Math.abs(cur_h - heights[cur.i+1][cur.j]);
                pq.offer(new Node(cur.i+1, cur.j, Math.max(cur.effort, diff)));
            }
            if(cur.j-1>=0 && !visited[cur.i][cur.j-1]){
                int diff = Math.abs(cur_h - heights[cur.i][cur.j-1]);
                pq.offer(new Node(cur.i, cur.j-1, Math.max(cur.effort, diff)));
            }
            if(cur.j+1<col && !visited[cur.i][cur.j+1]){
                int diff = Math.abs(cur_h - heights[cur.i][cur.j+1]);
                pq.offer(new Node(cur.i, cur.j+1, Math.max(cur.effort, diff)));
            }*/

        }

        return 0;
    }
}
