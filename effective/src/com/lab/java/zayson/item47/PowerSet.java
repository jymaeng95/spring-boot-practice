package com.lab.java.zayson.item47;

import java.util.*;

public class PowerSet {
    public static final <E> Collection<Set<E>> of(Set<E> set) {
        List<E> src = new ArrayList<>(set);
        if (src.size() > 30)
            throw new IllegalArgumentException("집합에 원소가 너무 많습니다. (최대 30개)"); // 2의 30승개

        return new AbstractList<>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }
        };
    }
}
