package com.rohit.practice.leetcode.matrix;

public class LT463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;

        int perimeter = 0;

        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(grid[i][j] == 1){
                    perimeter += 4;
                    if(i>0 && grid[i-1][j]==1)
                        perimeter -= 1;
                    if(i<rows-1 && grid[i+1][j]==1)
                        perimeter -= 1;
                    if(j>0 && grid[i][j-1]==1)
                        perimeter -= 1;
                    if(j<cols-1 && grid[i][j+1]==1)
                        perimeter -= 1;
                }
            }
        }

        return perimeter;
    }


    private boolean[][] visited;
    public int islandPerimeterdfs(int[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        int perimeter = 0;
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(!visited[i][j] && grid[i][j] == 1){
                    int cur = findIsland(grid, rows, cols, i, j);
                    perimeter = Math.max(perimeter, cur);
                    //return cur;
                }
            }
        }
        return perimeter;
    }

    private int findIsland(int[][] grid, int rows, int cols, int cur_row, int cur_col){
        if(cur_row < 0 || cur_row >= rows || cur_col < 0 || cur_col >= cols || grid[cur_row][cur_col] == 0){
            return 1;
        }

        if(visited[cur_row][cur_col])
            return 0;

        visited[cur_row][cur_col] = true;

        int up = findIsland(grid, rows, cols, cur_row-1, cur_col);
        int down = findIsland(grid, rows, cols, cur_row+1, cur_col);
        int left = findIsland(grid, rows, cols, cur_row, cur_col-1);
        int right = findIsland(grid, rows, cols, cur_row, cur_col+1);

        return up + down + left + right;
    }
}
