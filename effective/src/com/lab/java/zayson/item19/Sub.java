package com.lab.java.zayson.item19;


import java.time.Instant;

public final class Sub extends Super {
    // 초기화 되지 않은 final 필드, 생성자에서 초기화
    private final Instant instant;

    Sub() {
        // super() 호출 생략
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("instant = " + instant);
    }
}
