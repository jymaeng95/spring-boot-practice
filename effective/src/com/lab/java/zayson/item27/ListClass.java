package com.lab.java.zayson.item27;

import java.util.Arrays;

public class ListClass<T> {
    private int size;
    private T[] elements;
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 지역변수로 선언 후 비검사 경고 체크
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());

            return result;
        }
        if(a.length > size)
            a[size] = null;
        return a;
    }
}
