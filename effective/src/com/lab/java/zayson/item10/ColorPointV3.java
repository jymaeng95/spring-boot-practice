package com.lab.java.zayson.item10;

import java.util.Objects;

public class ColorPointV3 {
    private final Color color;
    private final Point point; // 사실상 하위 타입인 ColorPoint를 상위 타입처럼 리턴하고 싶은 경우 point를 리턴 (뷰)

    public ColorPointV3(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    // Point를 반환
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPointV3))
            return false;
        ColorPointV3 that = (ColorPointV3) o;
        return that.point.equals(point) && that.color == color;
    }
}
