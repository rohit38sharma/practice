package com.rohit.practice.LLD.Design.VendingMachin.state;

import com.rohit.practice.LLD.Design.VendingMachin.VendingMachine;
import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;
import com.rohit.practice.LLD.Design.VendingMachin.model.Item;

public class IdleState implements VendingMachineState{

    @Override
    public void pressInsertMoneyButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new HasMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, CoinType coinType) throws Exception {
        System.out.println("Insert money function not allowed when vending machine is in Idle state");
        throw new Exception("Insert money function not allowed when vending machine is in Idle state");
    }

    @Override
    public void pressItemSelectionButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Item select function not allowed when vending machine is in Idle state");
        throw new Exception("Item select function not allowed when vending machine is in Idle state");
    }

    @Override
    public void chooseItem(VendingMachine vendingMachine, int shelfCode) throws Exception {
        System.out.println("Item select function not allowed when vending machine is in Idle state");
        throw new Exception("Item select function not allowed when vending machine is in Idle state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        System.out.println("Cancel function not allowed when vending machine is in Idle state");
        throw new Exception("Cancel function not allowed when vending machine is in Idle state");
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refund money function not allowed when vending machine is in Idle state");
        throw new Exception("Refund money function not allowed when vending machine is in Idle state");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine, int changeAmount) throws Exception {
        System.out.println("Return change function not allowed when vending machine is in Idle state");
        throw new Exception("Return change function not allowed when vending machine is in Idle state");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine, int change) throws Exception {
        System.out.println("Dispense item function not allowed when vending machine is in Idle state");
        throw new Exception("Dispense item function not allowed when vending machine is in Idle state");
    }
}
