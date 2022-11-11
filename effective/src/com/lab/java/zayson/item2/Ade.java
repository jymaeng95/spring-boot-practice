package com.lab.java.zayson.item2;

public class Ade extends Beverage {
    public enum Fruit {STRAWBERRY, ORANGE, WATERMELON}

    private final Fruit fruit;

    public static class Builder extends Beverage.Builder<Builder> {
        private final Fruit fruit;

        public Builder(Size size, String menu, int price, Fruit fruit) {
            super(size, menu, price);
            this.fruit = fruit;
        }

        @Override
        Ade build() {
            return new Ade(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Ade(Builder builder) {
        super(builder);
        this.fruit = builder.fruit;
    }
}
