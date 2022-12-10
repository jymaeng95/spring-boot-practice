package com.lab.java.zayson.item23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SubTypeTest {
    @Test
    @DisplayName("태그 달린 클래스를 이용해서 클래스 정의")
    void 태그_달린_클래스() {
        // Square 정의
        Figure square = new Figure(1.0, 3.0);

        // Circle 정의
        Figure circle = new Figure(3.0);

        // Figure V2
        FigureV2 square2 = new Square(1.0, 3.0);
        FigureV2 circle2 = new Circle(3.0);

        assertThat(square.area()).isEqualTo(square2.area());
        assertThat(circle.area()).isEqualTo(circle2.area());
    }
}
