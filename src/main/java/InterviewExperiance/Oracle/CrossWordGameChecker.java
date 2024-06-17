package InterviewExperiance.Oracle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Find all the words possible within a crossword

    eg:  In the below matrix of characters some of the possible valid words but not all are as below.

    input:
       a b c
       t i l
       s p g

    output:
      bit
      blip
      clip
      sit
      ...


m * n
8
8*8
O((8 ^ (m*n)) * (m*n))
    */
public class CrossWordGameChecker {
    private class Trie{
        char c;
        boolean isEndOfWord;
        boolean isvalidWord;
        HashMap<Character, Trie> nextChars;
    }

    private List<String> validWords;
    private boolean[][] visited;

    private List<String> findAllValidWords(char[][] in, Trie root){
        validWords = new ArrayList<>();
        int m = in.length;
        if(m==0)
            return validWords;
        int n = in[0].length;

        visited = new boolean[m][n];

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){

                helper(in, root, i, j, m, n, new StringBuilder());
            }
        }

        return validWords;
    }

    private void helper(char[][] in, Trie root, int i, int j, int m, int n, StringBuilder sb){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])
            return;
        sb.append(in[i][j]);
        visited[i][j] = true;
        if(root.isvalidWord){
            validWords.add(sb.toString());
        }
        if(root.isEndOfWord)
            return;
        //Diagonal1
        if(i>0 && j>0 && root.nextChars.containsKey(in[i-1][j-1])){
            helper(in, root.nextChars.get(in[i-1][j-1]), i-1, j-1, m, n, sb);
        }
        //Diagonal2
        if(i<m-1 && j<n-1 && root.nextChars.containsKey(in[i+1][j+1])){
            helper(in, root.nextChars.get(in[i+1][j+1]), i+1, j+1, m, n, sb);
        }

    }
}
