package com.rohit.practice.LLD.Design.TicTacToe.Models;

public enum SymbolType {
    CROSS("X"),
    ZERO("0"),
    HASH("#"),
    DOLLAR("$");

    public final String label;

    private SymbolType(String label) {
        this.label = label;
    }
}
