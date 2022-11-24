package com.lab.java.zayson.item13;

import java.util.Arrays;
import java.util.HashMap;

public class HashTable implements Cloneable {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;
    private Entry[] buckets;

    public HashTable() {
        buckets = new Entry[DEFAULT_INITIAL_CAPACITY];

        // 임의의 객체 넣어놓기
        buckets[0] = new Entry("key", "value", null);
        size = 1;
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Version 1. buckets 배열 내 연결리스트는 복제된 인스턴스와 원본 인스턴스가 공유한다.
     */
    /*@Override
    public HashTable clone() {
        try {
            // 1. super.clone
            HashTable result = (HashTable) super.clone();

            // 2. Bucket이 가변 객체 배열이기 때문에 내부의 연결리스트 참조는 원본 인스턴스와 공유한다. (문제 발생)
            // 연결리스트의 참조 까지 복제 해야한다.
            result.buckets = buckets.clone();

            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }*/

    /**
     * Version 2. buckets 배열 내 연결리스트를 깊은 복사하는 경우 원본 인스턴스와 복제 인스턴스가 공유하지 않는다.
     */
    @Override
    public HashTable clone() {
        try {
            // 1. super.clone을 통해 원본 인스턴스 복제
            HashTable result = (HashTable) super.clone();

            // 2. buckets 배열을 새로 선언
            result.buckets = new Entry[buckets.length];

            // 3. 내부 원소값 복사
            for (int index = 0; index < buckets.length; index++) {
                if (buckets[index] != null)
                    result.buckets[index] = buckets[index].deepCopy();
            }

            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Entry[] getBuckets() {
        return buckets;
    }

    /**
     * 가변 참조 필드 연결리스트 확인
     */
    public Entry compareEntry() {
        return buckets[0];
    }
}
