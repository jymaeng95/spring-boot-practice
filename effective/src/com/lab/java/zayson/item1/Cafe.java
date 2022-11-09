package com.lab.java.zayson.item1;

public class Cafe extends Space{

    private final String name;

    public static final Cafe INSTANCE = new Cafe("Seoul", "Jongro", 1, "Starbucks");
    public Cafe(String city, String street, int floor, String name) {
        super(city, street, floor);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
