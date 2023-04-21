package com.lab.java.zayson.item89;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    // 인스턴스 통제를 위한 readResolve
    private Object readResolve() {
        // 진짜 Elvis를 반환, 가짜 Elvis 객체  가비짘 ㅓㄹㄹ게션 대상
        return INSTANCE;
    }
}
