package com.lab.java.zayson.item71;

import java.util.List;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            System.out.println("Thread Start");
            Thread.sleep(1000);
            System.out.println("Thread End");
        } catch (InterruptedException e) {
            // 1. 예외를 붙잡아 처리하는 방식
            e.printStackTrace();
            System.exit(1);
        }

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        numbers.stream()
//                .map(CheckedExceptionExample::actionWithThreadSleep)
                .forEach(System.out::println);

        if (actionPermitted(args)) {
            System.out.println("Some Logic");
        } else {
            System.out.println("Exception Logic");
        }
    }

    // throws를 통해서 예외를 바깥으로 던지는 방식
    private static void checkedExceptionAction() throws InterruptedException {
        System.out.println("Thread Start");
        Thread.sleep(1000);

        System.out.println("Thread End");
    }

    private static String actionWithThreadSleep(int number) throws InterruptedException {
        Thread.sleep(1000);

        return String.valueOf(number);
    }

    private static boolean actionPermitted(String[] args) {
        return args.length > 0; // 인수가 없는 경우 액션 실행 X
    }
}

