package com.rohit.practice.LLD.patterns.ObservablePattern.Observable;

import com.rohit.practice.LLD.patterns.ObservablePattern.Observer.NotifyObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{

    private List<NotifyObserver> observers;
    private int stockCount;

    public IphoneStockObservable(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(NotifyObserver obs) {
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(NotifyObserver obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObserver() {
        for(NotifyObserver observer : this.observers){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(this.stockCount == 0){
            notifyObserver();
        }
        this.stockCount += stockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
