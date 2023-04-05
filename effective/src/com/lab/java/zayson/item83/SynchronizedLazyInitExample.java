package com.lab.java.zayson.item83;

public class SynchronizedLazyInitExample {
    private FieldType field;

    private synchronized FieldType getField() {
        // 필드가 초기화 되지 않은 경우만 초기화 진행
        if (field == null) {
            field = computeFieldValue();
        }

        return field;
    }

    // 필드 초기화 메서드
    private FieldType computeFieldValue() {
        return new FieldType("zayson", "maeng");
    }
}
