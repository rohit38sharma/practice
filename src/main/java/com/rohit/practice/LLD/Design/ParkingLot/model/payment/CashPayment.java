package com.rohit.practice.LLD.Design.ParkingLot.model.payment;

public class CashPayment implements Payment {
    @Override
    public boolean completePayment(double amount) {
        System.out.println("Cash payment completed successfully for amount Rs." + amount);
        return true;
    }
}
