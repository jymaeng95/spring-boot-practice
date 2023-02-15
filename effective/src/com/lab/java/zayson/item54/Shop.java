package com.lab.java.zayson.item54;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private final List<Cheese> cheesesInStock = new ArrayList<>();

    // V1. 빈 컬렉션 대신 null을 반환하는 코드
    public List<Cheese> getCheeses() {
        // 컬렉션이 빈 경우 null을 리턴하는 좋지 않은 코드
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }

    // V2. 빈 컬렉션을 반환하는 코드 (매번 할당)
    public List<Cheese> getCheesesInStock() {
        return new ArrayList<>(cheesesInStock);
    }

    // V3. 매번 리스트를 생성하는 것이 아닌 빈 경우에만 새로운 빈 컬렉션을 생성해서 리턴
    public List<Cheese> getCheeseInStockV3() {
        return cheesesInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
    }

    // 길이가 0인 배열을 매번 생성해서 할당
    public Cheese[] getCheesesArray() {
        return cheesesInStock.toArray(new Cheese[0]);
    }

    // 길이가 0인 배열을 정적 멤버로 만들어서 공유
    private static final Cheese[] EMPTY_CHEESE_STOCK = new Cheese[0];
    public Cheese[] getCheeseArrayV2() {
        return cheesesInStock.toArray(EMPTY_CHEESE_STOCK);
    }

    public void addCheese(CheeseType type, int price) {
        cheesesInStock.add(new Cheese(type, price));
    }
}
