package com.rohit.practice.LLD.Design.rateLimiter.model;

public class Bucket {
    private long tokens;
    private long lastRefilled;

    public Bucket(long tokens, long lastRefilled){
        this.tokens = tokens;
        this.lastRefilled = lastRefilled;
    }

    public long getTokens(){
        return this.tokens;
    }

    public void setTokens(long tokens){
        this.tokens = tokens;
    }

    public long getLastRefilled(){
        return this.lastRefilled;
    }

    public void setLastRefilled(long lastRefilled){
        this.lastRefilled = lastRefilled;
    }
}
