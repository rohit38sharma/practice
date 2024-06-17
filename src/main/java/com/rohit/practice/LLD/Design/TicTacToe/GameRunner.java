package com.rohit.practice.LLD.Design.TicTacToe;

import com.rohit.practice.LLD.Design.TicTacToe.Models.Player;
import com.rohit.practice.LLD.Design.TicTacToe.Models.SymbolO;
import com.rohit.practice.LLD.Design.TicTacToe.Models.SymbolX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size:");
        int size = scanner.nextInt();

        /* System.out.println("Enter Number of player:");
        int playerCount = scanner.nextInt();
        scanner.nextLine();
        List<Player> players = new ArrayList<>();

        for(int i=0;i<playerCount;++i){
            System.out.println("Enter player name:");
            String name = scanner.nextLine();
            Player player = new Player(name, new SymbolX());
            players.add(player);
        }*/
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Player1", new SymbolX());
        Player player2 = new Player("Player2", new SymbolO());
        players.add(player1);
        players.add(player2);

        TicTacToeGame ticTacToeGame = new TicTacToeGame(size, players);
        Player winner = ticTacToeGame.startGame();

        if(winner == null) {
            System.out.println("Game Tie");
        }else{
            System.out.println("Player " + winner.getName() + " won the game!!!");
        }
    }

}
