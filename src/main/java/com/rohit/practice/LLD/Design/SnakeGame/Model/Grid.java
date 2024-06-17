package com.rohit.practice.LLD.Design.SnakeGame.Model;

import com.rohit.practice.LLD.Design.SnakeGame.Model.Direction;

public class Grid {
    private int height;
    private int width;
    private int[][] food;

    private int foodIdx;

    public Grid(int h, int w, int[][] food){
        this.height = h;
        this.width = w;
        this.food = food;
        this.foodIdx = 0;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean reachedFood(int row, int col){
        if(this.foodIdx < this.food.length
                && this.food[this.foodIdx][0] == row
                && this.food[this.foodIdx][1] == col){
            this.foodIdx += 1;
            return true;
        }
        return false;
    }

    public int flattenCell(int row, int col){
        return (row * this.width) + col;
    }

    public boolean hittingWall(int row, int col){
        if(row < 0 || row >= this.width || col < 0 || col >= this.height)
            return true;
        return false;
    }

    public int[] nextCellOnMove(Direction direction, int[] curCell){

        int row = curCell[0];
        int col = curCell[1];

        switch (direction){
            case UP:
                --row;
                break;
            case DOWN:
                ++row;
                break;
            case LEFT:
                --col;
                break;
            case RIGHT:
                ++col;
                break;
        }
        return new int[]{row, col};
    }
}
