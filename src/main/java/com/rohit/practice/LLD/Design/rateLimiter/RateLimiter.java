package com.rohit.practice.LLD.Design.rateLimiter;

import com.rohit.practice.LLD.Design.rateLimiter.model.Customer;

public interface RateLimiter {
    boolean isAllowed(Customer customer);
}
