package com.rohit.practice.LLD.Design.VendingMachin.constant;

public enum ItemType {
    DRINK(50),
    CHIPS(20),
    WATER(10),
    CHOCOLATE(20);

    public final int price;
    ItemType(int price){
        this.price = price;
    }
}
