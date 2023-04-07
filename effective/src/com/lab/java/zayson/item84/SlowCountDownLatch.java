package com.lab.java.zayson.item84;

public class SlowCountDownLatch {
    private int count;  // 공유 자원

    public SlowCountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        // 무한 루프를 돌면서 Busy Waiting
        while (true) {
            synchronized (this) {
                if(count == 0) return;
            }
        }
    }

    // 락을 잡은 스레드가 실행
    public synchronized void countDown() {
        if(count != 0) count--;
    }
}
