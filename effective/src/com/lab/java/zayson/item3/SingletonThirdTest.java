package com.lab.java.zayson.item3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonThirdTest {
    @Test
    @DisplayName("싱글톤 세 번째 방식 : enum (열거형)")
    void 열거_타입_방식() {
        SingletonThird singleton1 = SingletonThird.INSTANCE;
        SingletonThird singleton2 = SingletonThird.INSTANCE;

        assertThat(singleton1).isSameAs(singleton2);
    }
}