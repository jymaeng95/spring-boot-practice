package com.lab.java.zayson.item83;

public class NormalLazyInitExample {
    // 인스턴스 필드 지연 초기화 일반적인 방법
    private final FieldType field = computeFieldValue();

    private FieldType computeFieldValue() {
        return new FieldType("zayson", "maeng");
    }
}
