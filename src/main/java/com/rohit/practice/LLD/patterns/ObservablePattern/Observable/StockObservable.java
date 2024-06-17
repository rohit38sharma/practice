package com.rohit.practice.LLD.patterns.ObservablePattern.Observable;

import com.rohit.practice.LLD.patterns.ObservablePattern.Observer.NotifyObserver;

public interface StockObservable {
    public void addObserver(NotifyObserver obs);
    public void removeObserver(NotifyObserver obs);
    public void notifyObserver();

    public void setStockCount(int stockCount);

    public int getStockCount();

}
