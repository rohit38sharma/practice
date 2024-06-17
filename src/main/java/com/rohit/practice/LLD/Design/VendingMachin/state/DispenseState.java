package com.rohit.practice.LLD.Design.VendingMachin.state;

import com.rohit.practice.LLD.Design.VendingMachin.VendingMachine;
import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;
import com.rohit.practice.LLD.Design.VendingMachin.model.Item;

public class DispenseState implements VendingMachineState{
    public DispenseState(VendingMachine vendingMachine, int change){
        dispenseItem(vendingMachine, change);
    }
    @Override
    public void pressInsertMoneyButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, CoinType coinType) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void pressItemSelectionButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void chooseItem(VendingMachine vendingMachine, int shelfCode) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        throw new Exception("Vending machine is in Dispense state");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine, int changeAmount) {
        if(changeAmount > 0){
            System.out.println("Returning change of Rs. " + changeAmount);
        }
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, int change) {
        Item itemToDispense = vendingMachine.getItemToDispense();
        System.out.println("Dispensing item " + itemToDispense.getItemType());
        returnChange(vendingMachine, change);
        vendingMachine.setItemToDispense(null);
        vendingMachine.getCurrencyManager().resetInsertedMoney();
        vendingMachine.setState(new IdleState());
    }
}
