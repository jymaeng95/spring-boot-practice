package com.lab.java.zayson.item78;

import java.util.concurrent.TimeUnit;

public class StopThreadV2 {
    private static boolean stopRequested; // 공유하는 상태

    // 쓰기 연산 동기화
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    // 읽기 연산 동기화
    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgoundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested())  // 백그라운드 스레드는 메인 스레드가 락을 해제하면 변경된 상태를 읽을 수 있다. (읽기)
                i ++;
        });

        backgoundThread.start();  // 새로운 스레드 시작 (백그라운드)
        TimeUnit.SECONDS.sleep(1);  // 메인스레드 1초 슬립
        requestStop(); // 메인 스레드가 stopRequested 접근하기 위해 락을 걸어 상태 변경 (쓰기)
    }
}
