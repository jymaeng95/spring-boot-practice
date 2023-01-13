package com.lab.java.zayson.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    // 각각의 상수에서 메서드 오버라이딩을 통해 다른 동작을 하도록 구현
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    // 연산자 별로 다른 동작을 하도록 추상메서드 선언
    public abstract double apply(double x, double y);

    // 열거타입용 fromString을 구현하기
    private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    // 지정한 문자열에 해당하는 Operation을 반환
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
