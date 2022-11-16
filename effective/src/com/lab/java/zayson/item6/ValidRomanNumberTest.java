package com.lab.java.zayson.item6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidRomanNumberTest {
    @Test
    @DisplayName("객체 생성이 비싸고 반복해서 필요한 경우 캐싱한다.")
    void 로마_숫자_판별기() {
        // 객체를 매번 생성하므로 느리다.
        long startV1 = System.currentTimeMillis();
        boolean v1 = ValidRomanNumber.isRomanNumeralV1("VI");
        long endV1 = System.currentTimeMillis();

        long elapsedV1 = endV1 - startV1;
        System.out.println("V1 실행시간 : " + elapsedV1);

        // 객체를 캐싱하는 것이 더 빠르다.
        long startV2 = System.currentTimeMillis();
        boolean v2 = ValidRomanNumber.isRomanNumeralV2("VI");
        long endV2 = System.currentTimeMillis();

        long elapsedV2 = endV2 - startV2;
        System.out.println("V2 실행시간 : " + elapsedV2);

        Assertions.assertThat(elapsedV1).isGreaterThan(elapsedV2);
    }
}