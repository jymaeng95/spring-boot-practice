package com.lab.java.zayson.item78;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested; // 공유하는 상태

    public static void main(String[] args) throws InterruptedException {
        Thread backgoundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested)  // 메인 스레드가 1초 슬립 후 상태를 변경해서 종료될 것이라 예상
                i ++;
        });

        backgoundThread.start();  // 새로운 스레드 시작 (백그라운드)
        TimeUnit.SECONDS.sleep(1);  // 메인스레드 1초 슬립
        stopRequested = true;  // 메인스레드가 상태를 변경
    }
}
