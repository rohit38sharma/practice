package com.rohit.practice.leetcode.matrix;

import java.util.ArrayList;

public class LT1992FindAllGroupsofFarmland {
    private boolean[][] visited;
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        if(m==0)
            return new int[0][0];
        int n = land[0].length;

        visited = new boolean[m][n];
        ArrayList<int[]> groupOfFarmland = new ArrayList<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(land[i][j]==1 && !visited[i][j]){
                    int[] coordinates = {i, j, i, j};
                    groupOfFarmland.add(coordinates);
                    findFarmlandHelper(land, m, n, i, j, coordinates);
                }
            }
        }

        return groupOfFarmland.toArray(new int[groupOfFarmland.size()][]);
    }

    private void findFarmlandHelper(int[][] land, int m, int n, int r, int c, int[] coordinates){
        if(r<0 || r>=m || c<0 || c>=n || land[r][c]==0 || visited[r][c])
            return;
        if(r > coordinates[2] || c > coordinates[3]){
            coordinates[2] = r;
            coordinates[3] = c;
        }

        visited[r][c] = true;

        findFarmlandHelper(land, m, n, r-1, c, coordinates);
        findFarmlandHelper(land, m, n, r+1, c, coordinates);
        findFarmlandHelper(land, m, n, r, c-1, coordinates);
        findFarmlandHelper(land, m, n, r, c+1, coordinates);
    }
}
