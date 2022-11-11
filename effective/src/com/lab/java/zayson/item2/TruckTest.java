package com.lab.java.zayson.item2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    @DisplayName("빌더 패턴")
    void 빌더_패턴() {
        Truck truck = new Truck.Builder("현대", 2020)     // 1. 필수 파라미터를 담는다.
                .weight(1000)   // 2. 필요한 선택 파라미터를 담는다.
                .driveDistance(100000)
                .maxSpeed(200)
                .build();       // 3. 실제 객체를 생성한다.

        assertThat(truck).isInstanceOf(Truck.class);
        assertThat(truck.getCompany()).isEqualTo("현대");
    }
}