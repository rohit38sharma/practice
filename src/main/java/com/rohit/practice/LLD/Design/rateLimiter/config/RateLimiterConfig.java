package com.rohit.practice.LLD.Design.rateLimiter.config;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterConfig {
    private final long DEFAULT_NUMBER_OF_REQUEST = 5;
    private final long DEFAULT_WINDOW = 2;
    private Map<Integer, RateLimiterRule> ruleConfig;
    private final long MAX_CREDITS = 5;

    public RateLimiterConfig(){
        loadRateLimiterConfig();
    }

    private void loadRateLimiterConfig(){
        this.ruleConfig = new HashMap<>();
        //Load from DB or config file
    }

    public void addRuleConfig(Map<Integer, RateLimiterRule> rules){
        for(int customerId : rules.keySet()){
            addRuleConfig(customerId, rules.get(customerId));
        }
    }

    public void addRuleConfig(int customerId, RateLimiterRule rule){
        this.ruleConfig.put(customerId, rule);
    }

    public RateLimiterRule getRateLimiterRuleForCustomer(int customerId){
        if(!this.ruleConfig.containsKey(customerId)){
            System.out.println("Rate Limiter rule not found for customer id : " + customerId);
            System.out.println("Creating default rule");
            this.ruleConfig.put(customerId, createDefaultRule());
        }

        return this.ruleConfig.get(customerId);
    }

    private RateLimiterRule createDefaultRule(){
        return new RateLimiterRule(DEFAULT_NUMBER_OF_REQUEST, DEFAULT_WINDOW);
    }

    public long getMaxCredit(){
        return this.MAX_CREDITS;
    }
}
