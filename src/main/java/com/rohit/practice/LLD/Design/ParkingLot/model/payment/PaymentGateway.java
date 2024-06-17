package com.rohit.practice.LLD.Design.ParkingLot.model.payment;

import com.rohit.practice.LLD.Design.ParkingLot.constant.PaymentMode;

import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {

    private Map<PaymentMode, Payment> paymentMethods;
    private static PaymentGateway paymentGateway = null;

    private PaymentGateway() {
        this.paymentMethods = new HashMap<>();
    }

    public static PaymentGateway getInstance() {
        if (paymentGateway == null) {
            synchronized (PaymentGateway.class){
                if(paymentGateway == null){
                    paymentGateway = new PaymentGateway();
                }
            }
        }
        return paymentGateway;
    }

    public boolean acceptPayment(double amount, PaymentMode paymentMode){
        if(!this.paymentMethods.containsKey(paymentMode)){
            this.paymentMethods.put(paymentMode, paymentFactory(paymentMode));
        }
        return this.paymentMethods.get(paymentMode).completePayment(amount);
    }

    private Payment paymentFactory(PaymentMode paymentMode){
        if(paymentMode == PaymentMode.CASH)
            return new CashPayment();
        if(paymentMode == PaymentMode.CARD)
            return new CardPayment();
        return null;
    }
}
