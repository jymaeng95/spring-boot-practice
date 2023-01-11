package com.lab.java.zayson.item34;

import java.util.ArrayList;
import java.util.List;

public enum Product {
    FIGURE(10000, 0.2), SHOES(90000, 0.2), TV(1_000_000, 15.0), COMPUTER(600_000, 10.0);

    // 필드의 경우 생성자를 통해 값을 주입
    private final int price;
    private final double weight;

    Product(int price, double weight) {
        this.price = price;
        this.weight = weight;
    }


    // 접근자 getter를 통해 접근
    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public List<Integer> comparePricePercent(Product product) {
        List<Integer> priceList = new ArrayList<>();
        for (Product value : Product.values()) {
            priceList.add((value.price / product.getPrice()) * 100);
        }

        return priceList;
    }
}
