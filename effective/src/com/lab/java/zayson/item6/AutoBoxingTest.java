package com.lab.java.zayson.item6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AutoBoxingTest {
    @Test
    @DisplayName("오토박싱이 일어나는 연산의 경우 성능 저하 확인")
    void autoBoxing() {
        long startV1 = System.currentTimeMillis();
        AutoBoxing.sumV1();
        long endV1 = System.currentTimeMillis();
        long elapsedV1 = endV1 - startV1;
        System.out.println("V1 실행시간 (오토박싱) = " + elapsedV1);

        long startV2 = System.currentTimeMillis();
        AutoBoxing.sumV2();
        long endV2 = System.currentTimeMillis();
        long elapsedV2 = endV2 - startV2;
        System.out.println("V2 실행시간 (오토박싱X) = " + elapsedV2);

        assertThat(elapsedV1).isGreaterThan(elapsedV2);
    }
}