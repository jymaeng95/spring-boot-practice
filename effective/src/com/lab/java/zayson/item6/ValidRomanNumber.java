package com.lab.java.zayson.item6;

import java.util.regex.Pattern;

public class ValidRomanNumber {

    // V1 : 숫자 확인 유틸 메서드 (성능 개선 전)
    // 매번 Pattern 객체를 생성해서 사용한다.
    static boolean isRomanNumeralV1(String str) {
        return str.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // V2 : Pattern 객체를 매번 만들지 않고 생성해놓고 사용한다. (캐싱)
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralV2(String str) {
        return ROMAN.matcher(str).matches();
    }
}
