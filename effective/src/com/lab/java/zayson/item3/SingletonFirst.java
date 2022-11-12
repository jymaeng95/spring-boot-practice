package com.lab.java.zayson.item3;

import java.io.Serializable;

public class SingletonFirst implements Serializable {
    /**
     * public static final 방식의 싱글톤 클래스
     */
    public static final transient SingletonFirst INSTANCE = new SingletonFirst();

    // private으로 생성자를 막는다.
    private SingletonFirst() {}

    private Object readResolve() {
        return INSTANCE;
    }
}

