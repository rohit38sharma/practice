package com.rohit.practice.leetcode.trie;

import java.util.List;

public class LT648ReplaceWords {
    private class Trie{
        boolean isWord;
        char c;

        Trie[] next;

        public Trie(char c){
            this.c = c;
            this.next = new Trie[26];
        }

        public void addWord(String word, int idx){
            if(idx == word.length()){
                this.isWord = true;
                return;
            }

            if(this.next[word.charAt(idx) - 'a'] == null){
                this.next[word.charAt(idx) - 'a'] = new Trie(word.charAt(idx));
            }

            this.next[word.charAt(idx) - 'a'].addWord(word, idx+1);
        }

        private String searchWord(String word){
            Trie cur  = this;
            for(int i=0;i<word.length();++i){
                Trie next = cur.next[word.charAt(i)-'a'];
                if(next == null){
                    break;
                }
                if(next.isWord){
                    return word.substring(0, i+1);
                }

                cur = next;
            }

            return word;
        }
    }

    private Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie(' ');

        for(String word : dictionary){
            root.addWord(word, 0);
        }
        StringBuilder sb = new StringBuilder();

        int n = sentence.length();
        int i = 0;
        while(i<n){
            if(sentence.charAt(i) == ' '){
                sb.append(" ");
                ++i;
                continue;
            }

            int j=i+1;
            while(j<n && sentence.charAt(j) != ' '){
                ++j;
            }

            String newWord = root.searchWord(sentence.substring(i, j));
            sb.append(newWord);

            i = j;
        }

        return sb.toString();
    }
}
