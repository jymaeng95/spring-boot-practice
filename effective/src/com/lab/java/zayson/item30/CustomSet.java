package com.lab.java.zayson.item30;

import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    // v1. 로타입으로 만든 경우
    private static Set unionV1(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);

        return result;
    }

    // v2. 제너릭 타입으로 만드는 경우
    private static <E> Set<E> unionV2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);

        return result;
    }

    // 메인 함수
    public static void main(String[] args) {
        Set<String> s1 = Set.of("zayson", "maeng");
        Set<String> s2 = Set.of("chae", "young");

        Set<String> result = unionV2(s1, s2);
        System.out.println(result.toString());
    }
}
