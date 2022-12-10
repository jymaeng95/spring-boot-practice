package com.lab.java.zayson.item23;

public class Circle extends FigureV2{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
