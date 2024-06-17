package com.rohit.practice.LLD.Design.TicTacToe.Models;

public abstract class PlayingSymbol {
    SymbolType symbolType;

    public PlayingSymbol(SymbolType symbolType){
        this.symbolType = symbolType;
    }
}
