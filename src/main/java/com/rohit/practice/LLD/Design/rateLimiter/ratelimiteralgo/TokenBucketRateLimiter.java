package com.rohit.practice.LLD.Design.rateLimiter.ratelimiteralgo;

import com.rohit.practice.LLD.Design.rateLimiter.RateLimiter;
import com.rohit.practice.LLD.Design.rateLimiter.config.RateLimiterConfig;
import com.rohit.practice.LLD.Design.rateLimiter.config.RateLimiterRule;
import com.rohit.practice.LLD.Design.rateLimiter.model.Bucket;
import com.rohit.practice.LLD.Design.rateLimiter.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter implements RateLimiter {
    private Map<Integer, Bucket> buckets;
    private Map<Integer, Long> credits;
    private RateLimiterConfig rateLimiterConfig;

    public TokenBucketRateLimiter(){
        this.buckets = new HashMap<>();
        this.rateLimiterConfig = new RateLimiterConfig();
        this.credits = new HashMap<>();
    }
    @Override
    public boolean isAllowed(Customer customer) {
        long currentTimeInMills = System.currentTimeMillis();

        refillBucket(customer.getCustomerId(), currentTimeInMills);

        Bucket bucket = this.buckets.get(customer.getCustomerId());

        if(bucket.getTokens() > 0){
            bucket.setTokens(bucket.getTokens() - 1);
            return true;
        }else if(this.credits.getOrDefault(customer.getCustomerId(), 0L) > 0){
            this.credits.put(customer.getCustomerId(), this.credits.get(customer.getCustomerId()) - 1);
            return true;
        }

        return false;
    }

    private void refillBucket(int customerId, long currentTimeInMills){
        RateLimiterRule customerRule = this.rateLimiterConfig.getRateLimiterRuleForCustomer(customerId);
        if(!this.buckets.containsKey(customerId)){
            createNewBucket(customerId, customerRule.getMaxRequestInWindow(), currentTimeInMills);
            return;
        }

        Bucket customerBucket = this.buckets.get(customerId);
        long timeElapsed = currentTimeInMills - customerBucket.getLastRefilled();
        if(timeElapsed > customerRule.getWindowInMillis()){
            //Add credit
            addCredit(customerId, customerBucket.getTokens());

            //Refill Bucket
            customerBucket.setTokens(customerRule.getMaxRequestInWindow());
            customerBucket.setLastRefilled(currentTimeInMills);
        }
    }

    private void createNewBucket(int customerId, long maxRequest, long lastRefilled){
        Bucket bucket = new Bucket(maxRequest, lastRefilled);
        this.buckets.put(customerId, bucket);
    }

    public RateLimiterConfig getRateLimiterConfig(){
        return this.rateLimiterConfig;
    }

    public void addCredit(int customerId, long credit){
        long newCredit = Math.min(rateLimiterConfig.getMaxCredit(), this.credits.getOrDefault(customerId, 0L) + credit);
        this.credits.put(customerId, newCredit);
    }
}
