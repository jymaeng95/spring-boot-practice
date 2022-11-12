package com.lab.java.zayson.item3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonSecondTest {
    @Test
    @DisplayName("싱글톤 두번째 방식 : 정적 팩토리 메서드")
    void 정적_팩토리_메서드() {
        // 동일한 싱글턴 객체 접근
        SingletonSecond singleton1 = SingletonSecond.getInstance();
        SingletonSecond singleton2 = SingletonSecond.getInstance();

        assertThat(singleton1).isSameAs(singleton2);

        // Supplier로 호출 가능
        Supplier<SingletonSecond> supplier = SingletonSecond::getInstance;
        assertThat(singleton1).isSameAs(supplier.get());
    }

    @Test
    @DisplayName("제네릭 싱글톤 팩토리")
    void 제너릭_싱글톤_팩토리() {
        // 다양한 타입의 싱글턴 생성 가능
        List<String> stringList = SingletonSecond.emptyList();
        List<Integer> integerList1 = SingletonSecond.emptyList();
        List<Integer> integerList2 = SingletonSecond.emptyList();

        assertThat(integerList1).isSameAs(integerList2);
    }
}