package com.lab.java.zayson.item23;

public class Figure {
    // 태그를 담당하는 열거형 클래스 필드
    private final Shape shape;

    // SQUARE 태그에서 필요한 필드
    private double length;
    private double width;

    // CIRCLE에서 필요한 필드
    private double radius;

    // 생성자 이름이 동일하기 때문에 어떤 생성자가 사각형이고 원인지 모름 -> 잘못된 초기화로 인한 런타임 에러 발생 가능성 존재

    // SQUARE 정의
    public Figure(double length, double width) {
        this.shape = Shape.SQUARE;
        this.length = length;
        this.width = width;
    }

    // CIRCLE 정의
    public Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 타입 별로 달라지는 메서드
    public double area() {
        switch (shape) {
            case SQUARE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
