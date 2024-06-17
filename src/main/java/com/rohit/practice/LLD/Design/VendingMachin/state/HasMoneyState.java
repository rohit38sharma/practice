package com.rohit.practice.LLD.Design.VendingMachin.state;

import com.rohit.practice.LLD.Design.VendingMachin.VendingMachine;
import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;

public class HasMoneyState implements VendingMachineState{
    @Override
    public void pressInsertMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Vending machine is already in accepting money state");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, CoinType coinType) {
        vendingMachine.getCurrencyManager().insertMoney(coinType);
    }

    @Override
    public void pressItemSelectionButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void chooseItem(VendingMachine vendingMachine, int shelfCode) throws Exception {
        System.out.println("Please press Item selection button before choosing an item");
        throw new Exception("Please press Item selection button before choosing an item");
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
        System.out.println("Return change method not allowed when machine is in HasMoney state");
        throw new Exception("Return change method not allowed when machine is in HasMoney state");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, int change) throws Exception {
        System.out.println("Item can not be dispensed when machine is in HasMoney state");
        throw new Exception("Item can not be dispensed when machine is in HasMoney state");
    }
}
