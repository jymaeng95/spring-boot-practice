package com.lab.java.zayson.item52;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ClassOverloading {
    // Set 타입이 들어오면 집합 문자열을 리턴할 것이라 기대
    public static String classify(Set<?> set) {
        return "집합";
    }

    // List 타입이 들어오면 리스트 문자열을 리턴할 것이라 기대
    public static String classify(List<?> list) {
        return "리스트";
    }

    // 이외의 컬렉션이 들어오면 그 외 문자열을 리턴할 것이라 기대
    public static String classify(Collection<?> collection) {
        return "그 외";
    }

    public static String classifyV2(Collection<?> collection) {
        if (collection instanceof Set) return "집합";
        if (collection instanceof List) return "리스트";
        return "그 외";
    }
}
