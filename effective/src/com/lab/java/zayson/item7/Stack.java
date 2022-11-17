package com.lab.java.zayson.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;  // 메모리를 직접 관리
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 다 쓴 참조를 가비지 컬렉터가 회수하지 않는다.
    public Object popV1() {
        if(size == 0)
            throw new EmptyStackException();
        return elements[--size];  // 메모리 누수가 나는 부분
    }

    // 다 쓴 참조를 null 처리를 통해 가비지 컬렉터가 회수한다.
    public Object popV2() {
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
