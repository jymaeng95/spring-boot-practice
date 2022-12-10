package com.lab.java.zayson.item22;

// 2. 열거형으로 상수 인터페이스 구현 해결
public enum ConstantsV1 {
    AVO_NUMBER(1.0),
    ELEC_MASS (2.0);

    private final double value;

    ConstantsV1(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
