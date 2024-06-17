package InterviewExperiance.Oracle;

/* Problem Statement - Given matrix having 0 and 1 (mxn) ( where 0 water and 1 is land), Print the number of islands */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NumberOfIsland {
    public static void main(String[] args) {
        NumberOfIsland solution = new NumberOfIsland();

        int[][] input = {{0,1,0}, {0,1,0}, {0,0,1}};

        int ans = solution.numberOfIsland(input);

        System.out.println("Number of Island="+ans);
    }

    public int numberOfIsland(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];


        int numIsland = 0;

        //Scan the matrix
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    ++numIsland;
                    dfs(matrix, n, m, visited, i, j);
                }
            }
        }

        return numIsland;
    }

    private void dfs(int[][] matrix, int n, int m, boolean[][] visited, int i, int j){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || matrix[i][j]==0){
            return;
        }
        visited[i][j] = true;

        dfs(matrix, n, m, visited, i, j-1);
        dfs(matrix, n, m, visited, i, j+1);
        dfs(matrix, n, m, visited, i-1, j);
        dfs(matrix, n, m, visited, i+1, j);
    }
}
