package com.lab.java.zayson.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class CustomStack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public CustomStack() {
        // 1. 컴파일 에러 발생 (실체화 불가 타입으로 배열 생성 불가능)
//        elements = new E[DEFAULT_INITIAL_CAPACITY];

        // 2. 제너릭 배열 방식 우회 - 비검사 형변환이 타입 안정성을 해칠 것이라 판단$
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];

        /* 3. E[] elements 배열은 리턴되지 않고, push 메서드를 통해 E 타입만 들어가므로
         * 타입이 안정적임을 보장한다.
         */
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
