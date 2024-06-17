package com.rohit.practice.LLD.Design.VendingMachin.state;

import com.rohit.practice.LLD.Design.VendingMachin.VendingMachine;
import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;
import com.rohit.practice.LLD.Design.VendingMachin.model.Item;

public interface VendingMachineState {
    void pressInsertMoneyButton(VendingMachine vendingMachine) throws Exception;
    void insertMoney(VendingMachine vendingMachine, CoinType coinType) throws Exception;
    void pressItemSelectionButton(VendingMachine vendingMachine) throws Exception;
    void chooseItem(VendingMachine vendingMachine, int shelfCode) throws Exception;
    void cancel(VendingMachine vendingMachine) throws Exception;
    void refundFullMoney(VendingMachine vendingMachine) throws Exception;
    void returnChange(VendingMachine vendingMachine, int changeAmount) throws Exception;
    void dispenseItem(VendingMachine vendingMachine, int change) throws Exception;

}
