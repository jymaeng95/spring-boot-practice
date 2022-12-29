package com.lab.java.zayson.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class CustomStack<E> {
    // 편의상 리스트에 원소 넣기
    Stack<E> elements = new Stack<>();

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

    // Version 1 : 와일드카드 타입을 사용하지 않은 경우
    public void popAllV1(Collection<E> dst) {
        while(!elements.isEmpty()) {
            dst.add(elements.pop());
        }
    }

    // Version 2 : 와일드카드 타입을 사용한 경우 (E의 상위 타입이 모두 받아질 수 있음)
    public void popAllV2(Collection<? super E> dst) {
        while (!elements.isEmpty()) {
            dst.add(elements.pop());
        }
    }

    public int size() {
        return elements.size();
    }
}
