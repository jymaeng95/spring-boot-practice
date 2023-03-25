package com.lab.java.zayson.item77;

public class IgnoreExceptionExample {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (IllegalStateException ignored) {
            // 예외를 무시한 이유에 대해 주석으로 명시
        }
    }

    public static void doSomething() {
        System.out.println("doSomething");
        throw new IllegalStateException();
    }
}
