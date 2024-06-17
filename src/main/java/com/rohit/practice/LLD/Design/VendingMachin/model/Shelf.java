package com.rohit.practice.LLD.Design.VendingMachin.model;

import com.rohit.practice.LLD.Design.VendingMachin.constant.ItemType;

import java.util.LinkedList;
import java.util.Queue;

public class Shelf {
    private int code;
    private Queue<Item> items;
    private ItemType itemType;

    public Shelf(int code, ItemType itemType){
        this.code = code;
        this.items = new LinkedList<>();
        this.itemType = itemType;
    }

    public int getCode(){
        return this.code;
    }

    public Item getItem(){
        if(this.isEmpty())
            return null;
        return this.items.remove();
    }


    public ItemType getItemType(){
        return this.itemType;
    }

    public boolean addItem(Item item){
        if(item.getItemType() != this.itemType){
            System.out.println("Item type does not match with the shelf item type. Shelf item type is: " + this.itemType + ", provided item type is: " + item.getItemType());
            return  false;
        }
        this.items.offer(item);
        return true;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }
}
