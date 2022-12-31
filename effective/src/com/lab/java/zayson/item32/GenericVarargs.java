package com.lab.java.zayson.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenericVarargs {
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists; // Object 타입은 String의 상위타입
        objects[0] = intList; // objects는 실제로 String 타입 -> intList가 들어가면서 타입 안정성을 해치고 힙오염 발생
        String s = stringLists[0].get(0);  // 런타임 예외 발생
    }

    // 위험한 메서드
    static <T> T[] toArray(T... args) {
        return args; // 가변인수는 자동으로 배열이 생성되므로 배열로 리턴가능 = 참조를 노출
    }

    // pickTo 메서드 호출 시 가변인수 배열이 노출됨
    static <T> T[] pickTo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();
    }

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        // 갸변인수 배열을 인수 전달 목적으로만 사용
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }

    // LIst 방식으로 대체
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        // 갸변인수 배열을 인수 전달 목적으로만 사용
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }
}
