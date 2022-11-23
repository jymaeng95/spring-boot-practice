package com.lab.java.zayson.item12;

public class PersonV2 {
    private final int age;
    private final String name;

    public PersonV2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
