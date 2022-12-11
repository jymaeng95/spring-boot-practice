package com.lab.java.zayson.item25;

public class Creature {
    // 정적 멤버 클래스로 선언
    private static class Animal {
        static final String NAME = "ANIMAL";
    }
    
    // 정적 멤버 클래스로 선언
    private static class Insect {
        static final String NAME = "INSECT";
    }

    public static void main(String[] args) {
        System.out.println("Animal.NAME = " + Animal.NAME);
        System.out.println("Insect.NAME = " + Insect.NAME);
    }
}
