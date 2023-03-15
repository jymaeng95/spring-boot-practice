package com.lab.java.zayson.item69;

import java.util.Iterator;
import java.util.List;

public class ExceptionExample {
    public static void main(String[] args) {
        long correct = correctCode();
        long wrong = wrongCode();

        System.out.println("correct = " + correct);
        System.out.println("wrong = " + wrong);

        // 상태 검사 메서드 사용
        List<String> names = List.of("Zayson", "maeng", "joon");
        for (Iterator<String> iter = names.iterator(); iter.hasNext(); ) {  // hasNext를 통해 다음 원소 상태 검사
            System.out.println("iter.next() = " + iter.next());
        }
    }

    // 관용구를 사용하는 경우
    private static long correctCode() {
        int[] arr = createArr();

        long start = System.nanoTime();
        for (int i : arr) {
            // doSomething
        }
        long end = System.nanoTime();

        return end - start;
    }

    // 예외를 이용해 코드를 제어하는 경우
    private static long wrongCode() {
        int[] arr = createArr();

        long start = System.nanoTime();
        try {
            int index = 0;
            int result = 0;
            while (true) {
                result = arr[index++];
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        } finally {
            long end = System.nanoTime();
            return end - start;
        }
    }

    private static int[] createArr() {
        int[] arr = new int[1000000000];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = index;
        }

        return arr;
    }
}
