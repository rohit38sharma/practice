package com.rohit.practice.LLD.Design.rateLimiter.config;

import com.rohit.practice.LLD.Design.rateLimiter.model.Unit;

public class RateLimiterRule {
    private long maxRequestInWindow;
    private long window;
    private Unit unitType;

    public RateLimiterRule(long maxRequestInWindow, long window, Unit unitType){
        this.maxRequestInWindow = maxRequestInWindow;
        this.window = window;
        this.unitType = unitType;
    }

    public RateLimiterRule(long maxRequestInWindow, long window){
        this.maxRequestInWindow = maxRequestInWindow;
        this.window = window;
        this.unitType = Unit.SECONDS;
    }

    public long getMaxRequestInWindow(){
        return this.maxRequestInWindow;
    }

    public long getWindow(){
        return this.window;
    }

    public long getWindowInMillis(){
        switch (this.unitType){
            case MILLISECONDS:
                return this.window;
            case SECONDS:
                return this.window * 1000;
            case MINUTES:
                return this.window * 60 * 1000;
            case HOURS:
                return this.window * 3600 * 1000;
            case DAYS:
                return this.window * 24 * 3600 * 1000;
            default:
                return this.window;
        }
    }

    public Unit getUnitType(){
        return this.unitType;
    }

}
