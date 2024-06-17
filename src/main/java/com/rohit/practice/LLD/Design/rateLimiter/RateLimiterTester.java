package com.rohit.practice.LLD.Design.rateLimiter;

import com.rohit.practice.LLD.Design.rateLimiter.model.Customer;
import com.rohit.practice.LLD.Design.rateLimiter.ratelimiteralgo.TokenBucketRateLimiter;

public class RateLimiterTester {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new TokenBucketRateLimiter();

        Customer customer1 = new Customer(1);
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        Thread.sleep(2000);
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        Thread.sleep(2000);
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
        System.out.println(rateLimiter.isAllowed(customer1));
    }
}
