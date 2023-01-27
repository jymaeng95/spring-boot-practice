package com.lab.java.zayson.item43;

public class MathUtils {
    private int defaultNumber;

    public MathUtils(int defaultNumber) {
        this.defaultNumber = defaultNumber;
    }

    public MathUtils(){ }

    // 일반 메서드
    public int plus(int x, int y) {
        return x + y;
    }

    //  정적 메서드
    public static int minus(int x, int y) {
        return x - y;
    }

    // 디폴트 파라미터와 덧셈
    public int plusWithDefaultNumber(int x, int y) {
        return x + y + this.defaultNumber;
    }
}
