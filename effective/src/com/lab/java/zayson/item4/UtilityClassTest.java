package com.lab.java.zayson.item4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilityClassTest {
    @Test
    @DisplayName("유틸리티 클래스의 인스턴스화 불가 확인")
    void 유틸리티_클래스_테스트() {
        // 인스턴스 화 불가
//        UtilityClass utilityClass = new UtilityClass();

        // 유틸리티 클래스 내 정적 멤버, 메서드는 접근 가능
        System.out.println(UtilityClass.joinInformation());

        assertThat(UtilityClass.AGE).isEqualTo(28);
        assertThat(UtilityClass.NAME).isEqualTo("zayson");
    }
}