package com.lab.java.zayson.item83;

public class DoubleCheckSyntaxExample {
    private volatile FieldType field;

    private FieldType getField() {
        FieldType result = field;
        if (result != null) {   // 첫 번째 검사 (락 사용 안함)
            return result;
        }

        synchronized (this) {
            if (field == null)  // 두 번째 검사 (락 사용)
                field = computeFieldValue();
            return field;
        }
    }

    private FieldType computeFieldValue() {
        return new FieldType("zayson", "maeng");
    }
}
