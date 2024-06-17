package com.rohit.practice.LLD.patterns.adapter;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface{

    private OldCoffeeMachine oldVendingMachine;

    public CoffeeTouchscreenAdapter(){
        oldVendingMachine = new OldCoffeeMachine();
    }

    @Override
    public void chooseFirstSelection() {
        oldVendingMachine.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        oldVendingMachine.selectB();
    }
}
