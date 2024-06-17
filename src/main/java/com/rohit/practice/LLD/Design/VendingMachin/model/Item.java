package com.rohit.practice.LLD.Design.VendingMachin.model;

import com.rohit.practice.LLD.Design.VendingMachin.constant.ItemType;

public class Item {
    private ItemType itemType;
    private String itemDesc;

    public Item(ItemType itemType, String itemDesc){
        this.itemType = itemType;
        this.itemDesc = itemDesc;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemDesc() {
        return itemDesc;
    }
}
