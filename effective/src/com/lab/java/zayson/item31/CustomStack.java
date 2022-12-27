package com.lab.java.zayson.item31;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<E> {
    // 편의상 리스트에 원소 넣기
    List<E> elements = new ArrayList<>();

    // Version 1 : 와일드카드 타입을 사용하지 않은 경우
    public void pushAllV1(Iterable<E> src) {
        for (E e : src) {
            elements.add(e);
        }
    }

    // Version 2 : 와일드카드 타입을 사용 (E의 하위타입이 모두 가능)
    public void pushAllV2(Iterable<? extends E> src) {
        for (E e : src) {
            elements.add(e);
        }
    }

    public int size() {
        return elements.size();
    }
}
