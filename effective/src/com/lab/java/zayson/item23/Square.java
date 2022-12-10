package com.lab.java.zayson.item23;

public class Square extends FigureV2{
    private final double length;
    private final double width;

    public Square(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
