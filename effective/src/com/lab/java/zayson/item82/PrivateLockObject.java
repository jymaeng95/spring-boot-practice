package com.lab.java.zayson.item82;

public class PrivateLockObject {
    private final Object lock = new Object(); // 비공개 락 객체 생성 (외부에서 볼 수 없도록 private final로 사용)

    public void foo() {
        synchronized (lock) {
            // doSomething()
        }
    }
}
