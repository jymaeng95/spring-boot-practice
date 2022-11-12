package com.lab.java.zayson.item4;

public class UtilityClass {
    // 기본 생성자가 만들어지는 것을 막는다. (명시적으로 생성자 생성)
    private UtilityClass() {
        // 클래스 내에서 생성자를 호출하는 경우 예외 처리
        throw new AssertionError();
    }

    // 정적 멤버, 메서드만 존재
    public static final Integer AGE = 28;
    public static final String NAME = "zayson";

    public static String joinInformation() {
        return String.format("Name : %s, Age : %d ", NAME, AGE);
    }
}
