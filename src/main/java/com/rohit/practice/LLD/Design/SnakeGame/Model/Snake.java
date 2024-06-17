package com.rohit.practice.LLD.Design.SnakeGame.Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Snake {
    private Set<Integer> occupiedPos;
    private Deque<Integer> snakeBody;

    public Snake(int initialPos){
        this.occupiedPos = new HashSet<>();
        this.snakeBody = new ArrayDeque<>();
        occupiedPos.add(initialPos);
        snakeBody.offerFirst(initialPos);
    }

    public int getSnakeHeadPos(){
        return this.snakeBody.peekFirst();
    }

    public void removeSnakeTail(){
        int tail = this.snakeBody.pollLast();
        this.occupiedPos.remove(tail);
    }

    public boolean nextPosHittingSnakeBody(int nextHead){
        return this.occupiedPos.contains(nextHead);
    }

    public void updateSnakeHead(int nextHead){
        this.snakeBody.offerFirst(nextHead);
        this.occupiedPos.add(nextHead);
    }
}
