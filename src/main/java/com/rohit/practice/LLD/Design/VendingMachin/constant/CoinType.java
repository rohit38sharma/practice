package com.rohit.practice.LLD.Design.VendingMachin.constant;

public enum CoinType {
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);
    public final int value;

    CoinType(int value){
        this.value = value;
    }
}
