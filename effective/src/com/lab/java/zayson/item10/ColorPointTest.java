package com.lab.java.zayson.item10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ColorPointTest {
    @Test
    @DisplayName("V1 : Point, ColorPoint 객체의 대칭성 위배")
    void colorPoint_V1() {
        Point point = new Point(5, 0);
        ColorPointV1 colorPoint = new ColorPointV1(5, 0, Color.RED);

        // Point와 ColorPoint의 비교 V1 대칭성 위배
        assertThat(point.equals(colorPoint)).isTrue();  // Point의 equals : 색상을 무시(논리적으로 맞지않음)하고 Point타입으로 캐스팅해서 비교, point의 x,y는 동일하므로 true
        assertThat(colorPoint.equals(point)).isFalse();  // ColorPoint의 equals : Point 타입은 ColorPoint의 인스턴스가 아니므로 항상 false

        assertThat(point instanceof ColorPointV1).isFalse();
        assertThat(colorPoint instanceof Point).isTrue();
    }

    @Test
    @DisplayName("V2 : Point, ColorPoint 객체의 추이성 위배")
    void colorPoint_V2() {
        ColorPointV2 point1 = new ColorPointV2(5, 0, Color.RED);
        Point point2 = new Point(5, 0);
        ColorPointV2 point3 = new ColorPointV2(5, 0, Color.BLUE);

        /**
         * point1,point2 비교 : point2가 V2의 인스턴스가 아니기 때문에
         * point2, point3 비교 : 색상을 무시하고 비교, 캐스팅 후 x,y 비교 = true
         * point1, point3 비교 : 좌표는 동일하지만, 색상이 다르므로 false; (추이성 위배)
         */
        assertThat(point1.equals(point2)).isTrue();
        assertThat(point2.equals(point3)).isTrue();
        assertThat(point1.equals(point3)).isFalse();
    }

    @Test
    @DisplayName("V3 : 컴포지션 사용")
    void colorPoint_V3() {
        ColorPointV3 point1 = new ColorPointV3(5, 0, Color.RED);
        Point point2 = new Point(5, 0);
        ColorPointV3 point3 = new ColorPointV3(5, 0, Color.RED);

        assertThat(point1.asPoint().equals(point2)).isTrue();
        assertThat(point2.equals(point3.asPoint())).isTrue();
        assertThat(point1.asPoint().equals(point3.asPoint())).isTrue();
        assertThat(point1.equals(point3)).isTrue();
    }
}