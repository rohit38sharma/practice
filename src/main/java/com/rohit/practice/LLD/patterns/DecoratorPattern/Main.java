package com.rohit.practice.LLD.patterns.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new FarmHousePizza();
        System.out.println(basePizza.cost());

        basePizza = new PaneerToping(basePizza);
        System.out.println(basePizza.cost());

        basePizza = new ExtraCheeseTopping(basePizza);
        System.out.println(basePizza.cost());
    }
}
