package com.lab.java.zayson.item19;

public final class Man extends Person {
    private final String name;
    private final int age;
    public Man(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    // 하위 클래스 재정의
    @Override
    public void stop() {
        System.out.println("걸음을 멈추다");
        System.out.println("record() = " + record());
    }

    // 하위 클래스 재정의
    @Override
    public String record() {
        return String.format("남자 이름 : %s, 남자 나이 : %d, 이동 거리 : %d", name, age, super.distance);
    }
}
