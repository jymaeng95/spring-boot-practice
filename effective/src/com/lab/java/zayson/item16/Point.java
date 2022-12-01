package com.lab.java.zayson.item16;

public class Point {
    // 가변 필드를 private으로 선언하고 접근자를 이용하자
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 접근자 사용
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter의 경우 외부에서 변경해야하는 가변 필드인 경우 사용
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
