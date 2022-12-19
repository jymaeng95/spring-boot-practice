package com.lab.java.zayson.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackV1 {
    // Object 기반으로 했기 때문에 반환 값에서 타입 변경이 필요하다.
    // 제너릭을 사용하자.
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV1() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 다 쓴 참조를 null 처리를 통해 가비지 컬렉터가 회수한다.
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
