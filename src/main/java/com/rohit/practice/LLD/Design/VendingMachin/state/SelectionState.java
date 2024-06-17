package com.rohit.practice.LLD.Design.VendingMachin.state;

import com.rohit.practice.LLD.Design.VendingMachin.VendingMachine;
import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;
import com.rohit.practice.LLD.Design.VendingMachin.model.Shelf;

public class SelectionState implements VendingMachineState{
    @Override
    public void pressInsertMoneyButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Vending machine is already is in Item selection state");
        throw new Exception("Vending machine is already is in Item selection state");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, CoinType coinType) throws Exception {
        System.out.println("Vending machine is already is in Item selection state, can not insert money");
        throw new Exception("Vending machine is already is in Item selection state");
    }

    @Override
    public void pressItemSelectionButton(VendingMachine vendingMachine) {
        System.out.println("Vending machine is already is in Item selection state");
    }

    @Override
    public void chooseItem(VendingMachine vendingMachine, int shelfCode) throws Exception {
        Shelf shelf = vendingMachine.getShelf(shelfCode);
        if(shelf == null){
            System.out.println("Wrong code entered. Try again with correct shelf code.");
            return;
        }
        if(shelf.isEmpty()){
            System.out.println("Item is out of stock.");
            refundFullMoney(vendingMachine);
        }
        int totalInsertedMoney = vendingMachine.getCurrencyManager().totalInsertedMoney();
        if(shelf.getItemType().price > totalInsertedMoney){
            System.out.println("Amount inserted is lessor than the Item price. Inserted money is: " + totalInsertedMoney + ", Item price is: " + shelf.getItemType().price);
            refundFullMoney(vendingMachine);
            throw new Exception("Amount inserted is lessor than the Item price. Inserted money is: " + totalInsertedMoney + ", Item price is: " + shelf.getItemType().price);
        }
        vendingMachine.setItemToDispense(shelf.getItem());
        vendingMachine.setState(new DispenseState(vendingMachine, totalInsertedMoney - shelf.getItemType().price));
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Cancelling the process and refunding if any money collected");
        refundFullMoney(vendingMachine);
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
        int totalMoneyCollected = vendingMachine.getCurrencyManager().totalInsertedMoney();
        vendingMachine.getCurrencyManager().resetInsertedMoney();
        System.out.println("Refunded total money of Rs." + totalMoneyCollected);
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine, int changeAmount) throws Exception {
        System.out.println("Return change method not allowed when machine is in item selection state");
        throw new Exception("Return change method not allowed when machine is in item selection state");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, int change) throws Exception {
        System.out.println("Item can not be dispensed when machine is in item selection state");
        throw new Exception("Item can not be dispensed when machine is in item selection state");
    }
}
