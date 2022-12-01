package com.lab.java.zayson.item17;

import java.util.Objects;

// 불변 클래스가 되도록 상속을 막는다.
public final class Complex {
    private final double re;
    private final double im;

    // 생성자를 private
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // 정적 팩토리를 이용해서만 객체를 생성 (불변식 복장)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    // 불변 객체 내 계산을 새로운 불변객체로 만들어서 리턴 (스레드 세이프)
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}
