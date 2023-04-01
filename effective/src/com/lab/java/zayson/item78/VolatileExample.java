package com.lab.java.zayson.item78;

public class VolatileExample {
    public static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        /**
         * 증감연산자
         * 1. 필드를 읽는다.
         * 2. 필드의 값을 증가시킨다.
         * 2가지 연산으로 이뤄져 원자적인 연산이 아니다.
         */
        return nextSerialNumber++;
    }
}
