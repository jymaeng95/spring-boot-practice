package com.lab.java.zayson.item2;

public class Coffee extends Beverage {
    public enum Type {HOT, ICE}

    private final Type type;
    private final boolean addShot;
    private final boolean addSyrup;

    public static class Builder extends Beverage.Builder<Builder> {
        private final Type type;

        private boolean addShot;
        private boolean addSyrup;

        public Builder(Size size, String menu, int price, Type type) {
            super(size, menu, price);
            this.type = type;
        }

        public Builder addShot(boolean addShot) {
            this.addShot = addShot;
            return this;
        }

        public Builder addSyrup(boolean addSyrup) {
            this.addSyrup = addSyrup;
            return this;
        }

        @Override
        Coffee build() {
            return new Coffee(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Coffee(Builder builder) {
        super(builder);

        this.type = builder.type;
        this.addShot = builder.addShot;
        this.addSyrup = builder.addSyrup;
    }
}
