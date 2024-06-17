package com.rohit.practice.leetcode.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LT950RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing1(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        if(n<=2)
            return deck;

        Queue<Integer> q = new LinkedList<>();
        int i = n-1;
        q.offer(deck[i--]);
        q.offer(deck[i--]);
        while(i>=0){
            int last = q.remove();
            q.offer(last);
            q.offer(deck[i]);
            --i;
        }

        int[] ans = new int[n];
        i=n-1;
        while(!q.isEmpty()){
            ans[i] = q.remove();
            --i;
        }

        return ans;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Queue<Integer> queue = new LinkedList<>();

        // Create a queue of indexes
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }

        Arrays.sort(deck);

        // Put cards at correct index in result
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // Reveal Card and place in result
            result[queue.poll()] = deck[i];

            // Move next card to bottom
            queue.add(queue.poll());
        }
        return result;
    }
}
