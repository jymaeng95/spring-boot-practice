package com.lab.java.zayson.item8;

public class Timer implements AutoCloseable {
    private int second;
    private boolean available;  // 유효한 객체인지 기록

    public Timer() {
        this.second = 0;
        available = true;
    }

    public void countSecond() {
        second++;
        System.out.println("second = " + second);
    }

    public int getSecond() {
        // 이미 종료된 객체인지 판별 후 메서드 호출하도록 유도
        if (!available)
            throw new IllegalStateException("이미 종료된 객체입니다.");

        return second;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Timer Stop");

        // close 메서드 호출 시 해당 객체가 유효하지 않음을 기록
        available = false;
    }
}
