package com.lab.java.zayson.item38;

/**
 * 인터페이스에 정의한 apply 메서드를 각각의 열거 타입에서 재정의해서 사용
 */
public enum BasicOperation implements Operation{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            if(y == 0) throw new IllegalArgumentException("두번째 인자가 0이 될 수 없습니다.");
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
