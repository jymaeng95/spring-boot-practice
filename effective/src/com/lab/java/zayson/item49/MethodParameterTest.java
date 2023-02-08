package com.lab.java.zayson.item49;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodParameterTest {
    @Test
    @DisplayName("Objects.requireNonNull 메서드 예외와 함께 호출")
    void requireNonNull_test() {
        String name = null;
        int age = 20;
        Assertions.assertThrows(NullPointerException.class, () -> new Person(name, age));
    }
}
