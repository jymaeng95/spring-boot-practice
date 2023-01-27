package com.lab.java.zayson.item44;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.function.*;

import static org.assertj.core.api.Assertions.*;

public class FunctionalInterfaceTest {
    @Test
    @DisplayName("표준 함수형 인터페이스 테스트")
    void 기본_표준_함수형_인터페이스_사용() {
        // 1. UnaryOperator : 인수 1개를 받아 동일한 타입으로 리턴, Integer 인수를 받아 Integer return
        UnaryOperator<Integer> unaryOperator = (x) -> x + 10;
        assertThat(unaryOperator.apply(10)).isEqualTo(20);

        // 2. BinaryOperator : 동일한 타입 인수 2개를 받아 동일한 타입으로 리턴, Integer 인수 2개를 받아 Integer return
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        assertThat(binaryOperator.apply(10, 10)).isEqualTo(20);

        // 3. Predicate : 인수를 받아 boolean으로 리턴
        Predicate<Character> predicate = Character::isLowerCase;
        assertThat(predicate.test('C')).isFalse();

        // 4. Function : 인수를 받아 다른 타입으로 리턴 : String -> Integer
        Function<String, Integer> function = Integer::parseInt;
        assertThat(function.apply("10").intValue()).isEqualTo(10);

        // 5. Supplier : 인수를 받지 않고 지정한 타입으로 리턴 void -> LocalDateTime
        Supplier<LocalDateTime> supplier = LocalDateTime::now;
        assertThat(supplier.get()).isInstanceOf(LocalDateTime.class);

        // 6. Consumer
        Consumer<String> consumer = System.out::println;
        consumer.accept("consume my string String -> void ");
    }
}
