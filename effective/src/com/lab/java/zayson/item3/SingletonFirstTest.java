package com.lab.java.zayson.item3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonFirstTest {
    @Test
    @DisplayName("싱글톤 첫 번째 방식 : public static final로 선언한 인스턴스 접근")
    void 싱글톤_첫번째() {
        SingletonFirst singleton1 = SingletonFirst.INSTANCE;
        SingletonFirst singleton2 = SingletonFirst.INSTANCE;

        assertSame(singleton1, singleton2);
    }

    @Test
    @DisplayName("싱글톤 첫 번째 방식 : 리플렉션 API를 이용하면 접근이 가능하다")
    void 리플렉션_공격() throws Exception {
        // 리플렉션 API (AccessibleObject.setAccessible) 이용 시 private 생성자 호출 가능
        SingletonFirst singleton1 = SingletonFirst.INSTANCE;

        // 리플렉션 사용
        Constructor<SingletonFirst> constructor = SingletonFirst.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 리플렉션을 통해 private 생성자 접근 가능
        SingletonFirst singleton2 = constructor.newInstance();

        assertThat(singleton1).isNotSameAs(singleton2);
    }
}