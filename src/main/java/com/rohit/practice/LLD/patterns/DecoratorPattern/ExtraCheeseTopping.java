package com.rohit.practice.LLD.patterns.DecoratorPattern;

public class ExtraCheeseTopping extends ToppingsDecorator{
    private BasePizza basePizza;

    public ExtraCheeseTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 70;
    }
}
