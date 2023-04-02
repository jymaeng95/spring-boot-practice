package com.lab.java.zayson.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentCollectionExample {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String previousValue = map.putIfAbsent(s, s);  // 상태 의존적 수정 메서드
        return previousValue == null ? s : previousValue;
    }
}
