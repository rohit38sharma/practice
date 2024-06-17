package com.rohit.practice.LLD.patterns.DecoratorPattern;

public class PaneerToping extends ToppingsDecorator{

    private BasePizza basePizza;

    public PaneerToping(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 30;
    }
}
