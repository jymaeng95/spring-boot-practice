package com.lab.java.zayson.item10;

import java.util.Objects;

public class ColorPointV1 extends Point {
    private final Color color;

    public ColorPointV1(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     *  ColorPointV1에 equals를 구현하지 않는 경우 Point 클래스의 Equals를 가져다 쓴다.
     *  Point의 equals는 색상 비교가 없기 때문에 ColorPoint에 대한 완벽한 동치를 보장하지 않음 -> 오버라이딩 필요
     */

    /*
     * [대칭성 위배]
     * ColorPoint와 Point 비교하는 경우 다름
     * ColorPoint.equals 기준 Point 타입이 들어오면 instance가 아니기 때문에 항상 false처리
     * Point.equals 기준 ColorPoint를 Point 타입 캐스팅 진행 -> 색상 비교 안함
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointV1))
            return false;

        return super.equals(o) && ((ColorPointV1) o).color == color;
    }
}
