package com.rohit.practice.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class LT212WordSearchIIUsingTrie {
    private class Trie{
        char c;
        boolean isWord;
        Trie[] children;

        public Trie(char c){
            this.c = c;
            children = new Trie[26];
        }
        public Trie(){
            children = new Trie[26];
        }

        private void addwords(String[] words){
            for(int i=0;i<words.length;++i){
                insert(words[i]);
            }
        }

        private void insert(String word) {
            Trie cur = this;
            for(char c : word.toCharArray()){
                int k = c-'a';
                if(cur.children[k]==null){
                    cur.children[k] = new Trie(c);
                }
                cur = cur.children[k];
            }
            cur.isWord = true;
        }

        private void remove(String word){
            removeUtil(word, this, 0);
        }

        private boolean isEmpty(Trie root){
            for(int i=0;i<26;++i){
                if(root.children[i]!=null)
                    return false;
            }
            return true;
        }

        private Trie removeUtil(String word, Trie cur, int idx){
            if(cur==null)
                return null;
            if(idx==word.length()){
                cur.isWord = false;

                if(isEmpty(cur))
                    cur = null;

                return cur;
            }

            int childIdx = word.charAt(idx)-'a';
            cur.children[childIdx] = removeUtil(word, cur.children[childIdx], idx+1);

            if(isEmpty(cur) && !cur.isWord){
                cur = null;
            }

            return cur;
        }
    }



    private ArrayList<String> found;
    private boolean[][] visited;
    private StringBuilder sb;
    private Trie root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        root.addwords(words);

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        found = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                findWordHelper(board, i, j, m, n, root);
            }
        }
        return found;
    }

    private void findWordHelper(char[][] board, int i, int j, int m, int n, Trie cur){
        int k = board[i][j]-'a';
        if(visited[i][j] || cur==null || cur.children[k]==null)
            return;
        visited[i][j] = true;
        Trie next = cur.children[k];
        sb.append(board[i][j]);
        if(next.isWord){
            String str = sb.toString();
            found.add(str);
            next.isWord = false;
            root.remove(str);
        }
        if(i>0)
            findWordHelper(board, i-1, j, m, n, next);
        if(i<m-1)
            findWordHelper(board, i+1, j, m, n, next);
        if(j>0)
            findWordHelper(board, i, j-1, m, n, next);
        if(j<n-1)
            findWordHelper(board, i, j+1, m, n, next);
        sb.setLength(sb.length() - 1);
        visited[i][j] = false;
    }
}
