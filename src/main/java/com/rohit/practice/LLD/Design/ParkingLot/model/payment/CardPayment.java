package com.rohit.practice.LLD.Design.ParkingLot.model.payment;

public class CardPayment implements Payment {
    @Override
    public boolean completePayment(double amount) {
        System.out.println("Card payment completed successfully for amount Rs." + amount);
        return true;
    }
}
