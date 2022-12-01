package com.lab.java.zayson.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Car {
    // 외부에서 접근 가능한 상수 필드 선언
    public static final int MAX_SPEED = 200;

    // 상수 필드가 가변 객체인 경우 (배열)
    // private 배열을 선언하고, 방어적 복사를 이용하자.
    private static final String[] TYPES = {"SUV", "Sedan", "Motorcycle"};
    public static final List<String> valuesV2 = Collections.unmodifiableList(Arrays.asList(TYPES));

    // 배열을 방어적 복사하고 메서드로 리턴
    public static final String[] valuesV1() {
        return TYPES.clone();
    }
}
