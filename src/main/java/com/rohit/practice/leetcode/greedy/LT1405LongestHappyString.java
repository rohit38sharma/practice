package com.rohit.practice.leetcode.greedy;

import java.util.PriorityQueue;

public class LT1405LongestHappyString {
    private class Node{
        char ch;
        int freq;

        public Node(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((c1, c2) -> c2.freq - c1.freq);
        if(a>0)
            pq.offer(new Node('a', a));
        if(b>0)
            pq.offer(new Node('b', b));
        if(c>0)
            pq.offer(new Node('c', c));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Node first = pq.remove();
            addChars(sb, first, 2);

            if(pq.isEmpty()){
                break;
            }

            Node second = pq.remove();
            if(first.freq > second.freq){
                addChars(sb, second, 1);
            }else{
                addChars(sb, second, 2);
            }

            if(first.freq > 0)
                pq.offer(first);

            if(second.freq > 0)
                pq.offer(second);
        }

        return sb.toString();
    }

    private void addChars(StringBuilder sb, Node cur, int max){
        int freq = Math.min(max, cur.freq);
        for(int i=0;i<freq;++i){
            sb.append(cur.ch);
        }
        cur.freq -= freq;
    }
}
