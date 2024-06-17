package com.rohit.practice.LLD.Design.VendingMachin;

import com.rohit.practice.LLD.Design.VendingMachin.model.CurrencyManager;
import com.rohit.practice.LLD.Design.VendingMachin.model.Item;
import com.rohit.practice.LLD.Design.VendingMachin.model.Shelf;
import com.rohit.practice.LLD.Design.VendingMachin.state.IdleState;
import com.rohit.practice.LLD.Design.VendingMachin.state.VendingMachineState;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VendingMachine {
    private VendingMachineState state;
    private Map<Integer, Shelf> shelfMap;
    private Item itemToDispense;
    private CurrencyManager currencyManager;


    private static VendingMachine vendingMachine = null;

    private VendingMachine(){
        this.state = new IdleState();
        this.shelfMap = new HashMap<>();
        this.currencyManager = CurrencyManager.getInstance();
    }

    public static VendingMachine getVendingMachineInstance(){
        if(vendingMachine == null){
            synchronized (VendingMachine.class){
                if(vendingMachine == null){
                    vendingMachine = new VendingMachine();
                }
            }
        }
        return vendingMachine;
    }

    public VendingMachineState getState(){
        return this.state;
    }

    public void setState(VendingMachineState vendingMachineState){
        this.state = vendingMachineState;
    }

    public Shelf getShelf(int code){
        if(this.shelfMap.containsKey(code)){
            return this.shelfMap.get(code);
        }else{
            System.out.println("Shelf with code " + code + " does not exist.");
            return null;
        }
    }

    public void addShelf(Shelf shelf){
        this.shelfMap.put(shelf.getCode(), shelf);
    }

    public boolean removeShelf(Shelf shelf){
        if(!shelf.isEmpty()){
            System.out.println("Shelf can not be removed as it has items.");
            return false;
        }
        this.shelfMap.remove(shelf.getCode());
        return true;
    }

    public void setItemToDispense(Item item){
        this.itemToDispense = item;
    }

    public Item getItemToDispense(){
        return this.itemToDispense;
    }

    public CurrencyManager getCurrencyManager(){
        return this.currencyManager;
    }
}
