package com.lab.java.zayson.item6;

public class AutoBoxing {
    // AutoBoxing이 일어나는 경우
    static long sumV1() {
        Long sum = 0L;

        // 값을 더할 때마다 Long 객체를 새로 생성한다.
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        return sum;
    }

    static long sumV2() {
        long sum = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        return sum;
    }
}
