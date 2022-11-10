package com.lab.java.zayson.item2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("점층적 생성자 패턴")
    void 점층적_생성자_패턴() {
        // 파라미터가 많아지면 코드의 가독성 저하
        // 동일 타입에 대한 순서가 엉킨 경우 런타임 시에 치염적인 문제 가능

        // ex)  driveDistance (50,000), maxSpeed(200)의 파라미터 순서가 바뀐 경우
        Car car = new Car("KAKAO", 2022, 10000, 200, 50000);

        // 컴파일 시점에 모름 -> 런타임 시점에 예외 발생 가능
        assertThrows(IllegalArgumentException.class, car::exceedMaxSpeed);
    }
}