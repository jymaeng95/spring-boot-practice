package com.lab.java.zayson.item23;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubTypeTest {
    @Test
    @DisplayName("태그 달린 클래스를 이용해서 클래스 정의")
    void 태그_달린_클래스() {
        // Square 정의
        Figure square = new Figure(1.0, 3.0);

        // Circle 정의
        Figure circle = new Figure(3.0);

        System.out.println("square.area() = " + square.area());
        System.out.println("circle.area() = " + circle.area());

        square.print();
        circle.print();
    }
}
