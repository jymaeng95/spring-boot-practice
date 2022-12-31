package com.lab.java.zayson.item31;

import java.util.List;

public class Swapping {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // private helper 메서드를 이용
    // E 타입에서 E를 추출했으므로 동일한 타입임을 확인할 수 있음
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
