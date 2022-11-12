package com.lab.java.zayson.item3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingletonSecond {
    /**
     * private 생성자, private으로 인스턴스 생성
     * 정적 팩토리 메서드로 싱글톤 객체 제공
     */
    private static final SingletonSecond INSTANCE = new SingletonSecond();
    private static final List EMPTY_LIST = new ArrayList<>();

    // 정적 팩토리 메서드를 이용해 제네릭 싱글톤 팩토리 가능
    private SingletonSecond() {
        // 비정상적인 접근으로 생성하는 경우
        if(!Objects.isNull(INSTANCE))
            throw new RuntimeException("잘못된 접근");
    }
    // 정적 팩토리 메서드

    public static SingletonSecond getInstance() {
        return INSTANCE;
    }

    public static <T> List <T> emptyList() {
        return (List<T>) EMPTY_LIST;
    }
}
