package com.lab.java.zayson.item54;

public class Cheese {
    private final CheeseType type;
    private final int price;

    public Cheese(CheeseType type, int price) {
        this.type = type;
        this.price = price;
    }

    public CheeseType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
