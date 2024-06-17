package com.rohit.practice.LLD.Design.rateLimiter.model;

public class Customer {
    private int customerId;

    public Customer(int customerId){
        this.customerId = customerId;
    }

    public int getCustomerId(){
        return this.customerId;
    }
}
