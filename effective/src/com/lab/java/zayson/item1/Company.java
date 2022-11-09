package com.lab.java.zayson.item1;

public class Company extends Space{
    private final String name;

    public static final Company INSTANCE = new Company("Pangyo", "Daewang", 20, "KAKAO");
    public Company(String city, String street, int floor, String name) {
        super(city, street, floor);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
