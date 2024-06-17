package com.rohit.practice.LLD.Design.VendingMachin.model;

import com.rohit.practice.LLD.Design.VendingMachin.constant.CoinType;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManager {
    private Map<CoinType, Integer> existingMoney;
    private Map<CoinType, Integer> moneyInserted;

    private static CurrencyManager instance = null;

    private CurrencyManager(){
        this.existingMoney = new HashMap<>();
        this.moneyInserted = new HashMap<>();
    }

    public static CurrencyManager getInstance(){
        if(instance == null){
            synchronized (CurrencyManager.class){
                if(instance == null){
                    instance = new CurrencyManager();
                }
            }
        }
        return instance;
    }

    public void addMoney(CoinType coinType, int count){
        this.existingMoney.put(coinType, this.existingMoney.getOrDefault(coinType, 0) + count);
    }

    public void addMoney(Map<CoinType, Integer> coins){
        for(CoinType coin : coins.keySet()){
            addMoney(coin, coins.get(coin));
        }
    }

    public Map<CoinType, Integer> getChange(int amount){
        //Implement coin change algorithm
        return new HashMap<>();
    }

    public Map<CoinType, Integer> getCollectedMoney(){
        return this.moneyInserted;
    }

    public void insertMoney(CoinType coinType){
        int prevCount = this.moneyInserted.getOrDefault(coinType, 0);
        this.moneyInserted.put(coinType, prevCount + 1);
    }

    public int totalInsertedMoney(){
        int totalMoney = 0;
        for(CoinType coinType : this.moneyInserted.keySet()){
            totalMoney += coinType.value * this.moneyInserted.get(coinType);
        }
        return totalMoney;
    }

    public void resetInsertedMoney(){
        for(CoinType coinType : this.moneyInserted.keySet()){
            this.moneyInserted.remove(coinType);
        }
    }


}
