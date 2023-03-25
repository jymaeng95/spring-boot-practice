package com.lab.java.zayson.item76;

public class ImmutablePerson {
    private final int age;
    private final String name;
    private final int height;

    public ImmutablePerson(int age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
