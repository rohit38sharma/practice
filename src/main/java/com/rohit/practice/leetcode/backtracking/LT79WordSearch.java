package com.rohit.practice.leetcode.backtracking;

public class LT79WordSearch {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                boolean found = dfs(board, word, i, j, 0, m, n);
                if(found)
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx, int m, int n){
        if(idx >= word.length())
            return true;
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        visited[i][j] = true;
        boolean up = dfs(board, word, i-1, j, idx+1, m, n);
        boolean down = dfs(board, word, i+1, j, idx+1, m, n);
        boolean left = dfs(board, word, i, j-1, idx+1, m, n);
        boolean right = dfs(board, word, i, j+1, idx+1, m, n);
        visited[i][j] = false;
        return up || down || left || right;
    }
}
