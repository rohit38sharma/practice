package com.rohit.practice.LLD.Design.TicTacToe.Models;

public class Board {
    private int size;
    private PlayingSymbol[][] board;
    private int freeCellCount;

    public Board(int size){
        this.size = size;
        this.freeCellCount = size * size;
        this.board = new PlayingSymbol[size][size];
    }

    public int getFreeCellCount(){
        return this.freeCellCount;
    }


    public boolean placeSymbol(PlayingSymbol symbol, int rowPos, int colPos) {
        if(!validPosition(rowPos, colPos) || this.board[rowPos][colPos] != null){
            return false;
        }
        this.board[rowPos][colPos] = symbol;
        this.freeCellCount -= 1;
        return true;
    }

    private boolean validPosition(int rowPos, int colPos){
        if(rowPos < 0 || rowPos >= size || colPos < 0 || colPos >= size)
            return false;
        return true;
    }

    public boolean findWinner(PlayingSymbol symbol, int rowPos, int colPos) {
        if(!validPosition(rowPos, colPos))
            return false;
        boolean row, col, diagonal1, diagonal2;
        row = col = diagonal1 = diagonal2 = true;
        //Check Row
        for(int i=0;i<size;++i){
            if(this.board[rowPos][i] == null || this.board[rowPos][i].symbolType != symbol.symbolType){
                row = false;
                break;
            }
        }
        //Check Col
        for(int i=0;i<size;++i){
            if(this.board[i][colPos] == null || this.board[i][colPos].symbolType != symbol.symbolType){
                col = false;
                break;
            }
        }
        //Check Diagonal1
        for(int i=0;i<size;++i){
            if(this.board[i][i] == null || this.board[i][i].symbolType != symbol.symbolType){
                diagonal1 = false;
                break;
            }
        }
        //Check Diagonal1
        for(int i=0;i<size;++i){
            if(this.board[i][this.size - i - 1] == null || this.board[i][this.size - i - 1].symbolType != symbol.symbolType){
                diagonal2 = false;
                break;
            }
        }

        return row || col || diagonal1 || diagonal2;
    }

    public void printBoard() {
        for(int i=0;i<this.size;++i){
            System.out.println();
            for(int j=0;j<this.size;++j){
                if(j>0)
                    System.out.print(" | ");
                if(this.board[i][j] == null)
                    System.out.print(" ");
                else
                    System.out.print(this.board[i][j].symbolType.label);
            }
        }
        System.out.println();
    }
}
