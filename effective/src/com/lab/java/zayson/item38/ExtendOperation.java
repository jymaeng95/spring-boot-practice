package com.lab.java.zayson.item38;

/**
 * Operation에 정의한 apply 메서드를 오버라이딩 해서 열거 타입확장
 * 즉, BasicOperation, ExtendOperation 두 열거 타입 모두 Operation 인터페이스를 구현
 * 각각의 열거타입에 apply 추상 메서드를 정의하지 않아도됨
 */
public enum ExtendOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendOperation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return symbol;
    }
}
