package com.lab.java.zayson.item13;

/**
 * Cloneable을 구현해야 clone 메서드가 동작
 */
public class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;  // 불변 필드

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public PhoneNumber clone() throws CloneNotSupportedException {
        // super.clone 호출을 통해 완벽한 복제본 획득
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("발생할 수 없음");
        }
    }
}
