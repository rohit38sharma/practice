package com.rohit.practice.LLD.Design.TicTacToe.Models;

public class Player {
    private String name;
    private PlayingSymbol symbol;

    public Player(String name, PlayingSymbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(PlayingSymbol symbol) {
        this.symbol = symbol;
    }
}
