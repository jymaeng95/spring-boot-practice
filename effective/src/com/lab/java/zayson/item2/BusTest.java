package com.lab.java.zayson.item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    @Test
    @DisplayName("자바 빈즈 패턴 : 객체 생성 이전까지 데이터의 일관성을 유지하는 것이 불가능")
    void 자바_빈즈_패턴() {
        /**
         * 요구사항 : 버스 (현대, 2020, 500kg, 0, 150) 객체 생성
         */

        // 객체 생성을 위해 여러 개의 메서드 호출 필요
        Bus bus = new Bus();
        bus.setCompany("현대");
        bus.setYear(2020);
        bus.setWeight(500);
        bus.setDriveDistance(0);
        bus.setMaxSpeed(150);

        // 객체가 완전히 생성되기 이전에 일관성이 무너진다.
        // maxSpeed를 바꾸는 버그 코드가 생성된 경우
        bus.setMaxSpeed(500);

        // 일관성을 유지 못해서 요구사항을 벗어나 예외가 발생!
        assertThrows(IllegalArgumentException.class, bus::exceedMaxSpeed);
    }
}