package com.lab.java.zayson.item31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomStackTest {
    @Test
    @DisplayName("와일드카드 타입을 사용하지 않은 pushAll")
    void 와일드카드타입_X_pushAll() {
        CustomStack<Number> stack = new CustomStack<>();

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

//        stack.pushAllV1(integerList); // 컴파일 에러 발생 (제네릭은 불공변, Integer가 Number의 하위 타입이지만 불공변이므로 컴파일 에러)
    }

    @Test
    @DisplayName("와일드카드 타입을 사용한 pushAll")
    void 와일드카드타입을_사용한_pushAll() {
        CustomStack<Number> stack = new CustomStack<>();

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        // 와일드카드 타입 사용을 통해 Number의 하위 타입도 넣어줌
        stack.pushAllV2(integerList);
        assertThat(stack.size()).isEqualTo(5);
    }
}
