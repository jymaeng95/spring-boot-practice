package com.lab.java.zayson.item14;

public class Coffee implements Comparable<Coffee> {
    private final int price;
    private final String menu;

    public Coffee(int price, String menu) {
        this.price = price;
        this.menu = menu;
    }

    // 객체 참조 필드가 하나인 경우 (관계 연산자를 이용하지 않기)
    @Override
    public int compareTo(Coffee o) {
        return Integer.compare(this.price, o.price);
    }

    public int getPrice() {
        return price;
    }
}
