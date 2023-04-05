package com.lab.java.zayson.item83;

public class StaticLazyInitExample {
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
        private static FieldType computeFieldValue() {
            return new FieldType("zayson", "maeng");
        }
    }

    // getField에 접근하는 동시에 field의 omputeFieldValue 메서드가 호출되면서 초기화
    private static FieldType getField() {
        return FieldHolder.field;
    }
}
