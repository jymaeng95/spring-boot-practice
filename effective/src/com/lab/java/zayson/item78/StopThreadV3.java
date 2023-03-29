package com.lab.java.zayson.item78;

import java.util.concurrent.TimeUnit;

public class StopThreadV3 {
    private static volatile boolean stopRequested; // 메인 메모리에서 값을 읽어 최신값 보장

    public static void main(String[] args) throws InterruptedException {
        Thread backgoundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested)  // volatile로 선언되 있으므로 최신값을 보장
                i ++;
        });

        backgoundThread.start();  // 새로운 스레드 시작 (백그라운드)
        TimeUnit.SECONDS.sleep(1);  // 메인스레드 1초 슬립
        stopRequested = true;  // 메인스레드가 상태를 변경
    }
}
