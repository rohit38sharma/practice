package com.rohit.practice.LLD.Design.SnakeGame;

import com.rohit.practice.LLD.Design.SnakeGame.Model.Direction;

public class SnakeGameRunner {
    public static void main(String[] args) {
        int h = 6;
        int w = 10;
        int[][] food = new int[6][2];
        food[0] = new int[]{0, 3};
        food[1] = new int[]{1, 4};
        food[2] = new int[]{4, 2};
        food[3] = new int[]{3, 4};
        food[4] = new int[]{0, 1};
        food[5] = new int[]{5, 4};

        SnakeGame snakeGame = new SnakeGame(h, w, food);

        System.out.println(snakeGame.move(Direction.RIGHT));
        System.out.println(snakeGame.move(Direction.RIGHT));
        System.out.println(snakeGame.move(Direction.RIGHT));
        System.out.println(snakeGame.move(Direction.DOWN));
        System.out.println(snakeGame.move(Direction.RIGHT));
        System.out.println(snakeGame.move(Direction.DOWN));
        System.out.println(snakeGame.move(Direction.DOWN));
        System.out.println(snakeGame.move(Direction.DOWN));
        System.out.println(snakeGame.move(Direction.LEFT));
        System.out.println(snakeGame.move(Direction.LEFT));
        System.out.println(snakeGame.move(Direction.LEFT));
        System.out.println(snakeGame.move(Direction.LEFT));
        System.out.println(snakeGame.move(Direction.LEFT));
    }
}
