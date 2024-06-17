package com.rohit.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LT51NQueens {
    private List<List<String>> solutions;
    private boolean[][] chessboard;
    private HashSet<Integer> cols;
    private HashSet<Integer> diag1;
    private HashSet<Integer> diag2;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        chessboard = new boolean[n][n];
        cols = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        helper(n, 0);

        return solutions;
    }

    private void helper(int n, int row){
        if(row==n){
            solutions.add(addSolution(n));
            return;
        }

        for(int col=0;col<n;++col){
            if(isSafe2(row, col)){
                chessboard[row][col] = true;
                cols.add(col);
                diag1.add(row+col);
                diag2.add(row-col);
                helper(n, row+1);
                chessboard[row][col] = false;
                cols.remove(col);
                diag1.remove(row+col);
                diag2.remove(row-col);
            }
        }
    }

    private boolean isSafe(int n, int row, int col){
        for(int i=1;i<=row;++i){
            if(row-i>=0){
                if(chessboard[row-i][col])
                    return false;
                if(col-i>=0 && chessboard[row-i][col-i])
                    return false;
                if(col+i<n && chessboard[row-i][col+i])
                    return false;
            }
        }

        return true;
    }

    private boolean isSafe2(int row, int col){
        if(cols.contains(col))
            return false;
        if(diag1.contains(row+col))
            return false;
        if(diag2.contains(row-col))
            return false;
        return true;
    }

    private List<String> addSolution(int n){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;++j){
                if(chessboard[i][j])
                    sb.append('Q');
                else
                    sb.append('.');
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
