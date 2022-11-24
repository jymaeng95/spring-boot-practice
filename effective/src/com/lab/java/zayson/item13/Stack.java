package com.lab.java.zayson.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable{
    private Object[] elements;  // 가변 필드 (super.clone)을 통해 배열 자체를 복제-> 원본 인스턴스와 복제된 인스턴스가 배열의 참조주소를 공유하는 문제 발생
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

    @Override
    public Stack clone() throws CloneNotSupportedException {
        try {
            // 1. super.clone으로 복제
            Stack result = (Stack) super.clone();

            // 2. 가변 필드인 elements 배열 수정
            result.elements = elements.clone();

            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
