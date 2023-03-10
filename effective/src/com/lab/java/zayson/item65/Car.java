package com.lab.java.zayson.item65;

public class Car {
    private final String name;
    private int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void speedUp() {
        speed++;
    }

    public int getSpeed() {
        return speed;
    }
}
