package com.lab.java.zayson.item19;

public class Super {

    // 상위 클래스의 생성자가 하위 클래스의 생성자보다 먼저 호출된다.
    public Super() {
        // 하위 클래스의 생성자보다 하위 클래스에서 재정의한 메서드가 먼저 호출되는 문제 발생
        overrideMe();
    }

    // 재정의할 메서드
    public void overrideMe() {

    }
}
