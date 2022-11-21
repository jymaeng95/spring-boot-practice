package com.lab.java.zayson.item10;

public class ColorPointV2 extends Point {
    private final Color color;

    public ColorPointV2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * ColorPointV1에 equals를 구현하지 않는 경우 Point 클래스의 Equals를 가져다 쓴다.
     * Point의 equals는 색상 비교가 없기 때문에 ColorPoint에 대한 완벽한 동치를 보장하지 않음 -> 오버라이딩 필요
     */

    /**
     * [추이성 위배]
     * Point 타입이 들어오는 경우 : 색상을 무시하고 비교
     * ColorPoint 타입이 들어오는 경우 색상까지 비교
     */
    @Override
    public boolean equals(Object o) {
        // Point 인스턴스가 아닌 경우 false
        if(!(o instanceof Point))
            return false;

        // Point, Point를 상속하는 다른 하위 객체가 들어오는 경우
        if(!(o instanceof ColorPointV2))
            return o.equals(this);

        return super.equals(o) && ((ColorPointV2) o).color == color;
    }
}
