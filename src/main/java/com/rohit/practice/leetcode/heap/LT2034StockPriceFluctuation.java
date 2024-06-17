package com.rohit.practice.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LT2034StockPriceFluctuation {
    private class Stock{
        int timestamp;
        int price;

        public Stock(int timestamp, int price){
            this.timestamp = timestamp;
            this.price = price;
        }
    }

    private Map<Integer, Integer> priceAtTimeStamp;
    private PriorityQueue<Stock> maxPrice;
    private PriorityQueue<Stock> minPrice;
    private int curTimeStamp;

    public LT2034StockPriceFluctuation() {
        this.priceAtTimeStamp = new HashMap<>();
        this.maxPrice = new PriorityQueue<>((a,b) -> b.price - a.price);
        this.minPrice = new PriorityQueue<>((a,b) -> a.price - b.price);
        this.curTimeStamp = 0;
    }

    public void update(int timestamp, int price) {
        this.priceAtTimeStamp.put(timestamp, price);

        if(this.curTimeStamp < timestamp){
            this.curTimeStamp = timestamp;
        }
        Stock stock = new Stock(timestamp, price);
        this.maxPrice.offer(stock);
        this.minPrice.offer(stock);
    }

    public int current() {
        return this.priceAtTimeStamp.getOrDefault(this.curTimeStamp, -1);
    }

    public int maximum() {
        Stock max = this.maxPrice.peek();
        while(!this.maxPrice.isEmpty() && this.priceAtTimeStamp.get(max.timestamp) != max.price){
            this.maxPrice.remove();
            max = this.maxPrice.peek();
        }

        return max.price;
    }

    public int minimum() {
        Stock min = this.minPrice.peek();
        while(!this.minPrice.isEmpty() && this.priceAtTimeStamp.get(min.timestamp) != min.price){
            this.minPrice.remove();
            min = this.minPrice.peek();
        }

        return min.price;
    }
}
