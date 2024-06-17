package com.rohit.practice.LLD.Design.TicTacToe;

import com.rohit.practice.LLD.Design.TicTacToe.Models.Board;
import com.rohit.practice.LLD.Design.TicTacToe.Models.Player;

import java.util.*;

public class TicTacToeGame {
    private Board board;
    private Queue<Player> players;

    public TicTacToeGame(int size, List<Player> players){
        initialiseGame(size, players);
    }

    private void initialiseGame(int size, List<Player> players){
        this.board = new Board(size);
        this.players = new LinkedList<>(players);
    }

    public Player startGame(){
        boolean winner;
        int freeCell = this.board.getFreeCellCount();
        Scanner scanner = new Scanner(System.in);
        int rowPos=0, colPos=0;
        boolean placeSymbol;

        while(freeCell > 0){
            this.board.printBoard();
            Player curPlayer = this.players.remove();
            System.out.println("Player " + curPlayer.getName() + " turn");
            placeSymbol = false;
            while(!placeSymbol){
                System.out.println("Enter row number to place symbol:");
                rowPos = scanner.nextInt();
                System.out.println("Enter column number to place symbol:");
                colPos = scanner.nextInt();
                placeSymbol = this.board.placeSymbol(curPlayer.getSymbol(), rowPos, colPos);
                if(!placeSymbol){
                    System.out.println("Invalid position entered to place symbol. Please enter the position again.");
                }
            }

            winner = this.board.findWinner(curPlayer.getSymbol(), rowPos, colPos);
            if(winner){
                return curPlayer;
            }

            freeCell = this.board.getFreeCellCount();

            this.players.offer(curPlayer);
        }

        return null;
    }
}
