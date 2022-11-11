package com.lab.java.zayson.item2;

import java.util.EnumSet;
import java.util.Set;

public abstract class Beverage {
    public enum Size {TALL, GRANDE, VENTI}

    private final Size size;
    private final String menu;
    private final int price;

    abstract static class Builder<T extends Builder<T>> {
        private final Size size;
        private final String menu;
        private final int price;

        public Builder(Size size, String menu, int price) {
            this.size = size;
            this.menu = menu;
            this.price = price;
        }

        // 하위 타입의 재정의 = 하위 타입 객체로 반환
        abstract Beverage build();

        protected abstract T self();
    }

    public Beverage(Builder<?> builder) {
        this.size = builder.size;
        this.menu = builder.menu;
        this.price = builder.price;
    }
}
