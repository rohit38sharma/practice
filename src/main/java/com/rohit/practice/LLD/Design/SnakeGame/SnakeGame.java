package com.rohit.practice.LLD.Design.SnakeGame;

import com.rohit.practice.LLD.Design.SnakeGame.Model.Direction;
import com.rohit.practice.LLD.Design.SnakeGame.Model.Grid;
import com.rohit.practice.LLD.Design.SnakeGame.Model.Snake;

public class SnakeGame {
    private Grid grid;
    private Snake snake;
    private int score;

    public SnakeGame(int h, int w, int[][] food){
        this.grid = new Grid(h, w, food);
        this.snake = new Snake(0);
        this.score = 0;
    }

    public int move(Direction direction){
        int head = this.snake.getSnakeHeadPos();

        int[] curCell = {head / this.grid.getWidth(), head % this.grid.getWidth()};

        int[] nextCell = this.grid.nextCellOnMove(direction, curCell);

        int row = nextCell[0];
        int col = nextCell[1];

        int nextHead = this.grid.flattenCell(row, col);

        //Next move hitting wall? If yes, return -1
        if(this.grid.hittingWall(row, col)){
            return -1;
        }

        //Next move reaching food? If yes, eat food and increase score. If not, remove tail.
        if(this.grid.reachedFood(row, col)){
            this.score += 1;
        }else{
            this.snake.removeSnakeTail();
        }

        //Next move hitting the snake body? If yes, return -1
        if(this.snake.nextPosHittingSnakeBody(nextHead)){
            return -1;
        }

        this.snake.updateSnakeHead(nextHead);

        return this.score;
    }

}
