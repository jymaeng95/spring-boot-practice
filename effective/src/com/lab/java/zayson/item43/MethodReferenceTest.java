package com.lab.java.zayson.item43;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class MethodReferenceTest {
    @Test
    @DisplayName("정적 메서드 참조")
    void 정적_메서드_참조() {
        // 람다식 표현
        BiFunction<Integer, Integer, Integer> biFunction = (x,y) ->  MathUtils.minus(x, y);
        assertThat(biFunction.apply(10, 5)).isEqualTo(5);

        // 메서드 참조
        BiFunction<Integer, Integer, Integer> biFunction2 = MathUtils::minus;
        assertThat(biFunction2.apply(10, 5)).isEqualTo(5);
    }

    @Test
    @DisplayName("한정적(인스턴스) 메서드 참조")
    void 한정적_인스턴스_메서드_참조() {
        // 특정 객체 인스턴스화
        MathUtils mathUtils = new MathUtils();

        // 람다식
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> mathUtils.plus(x, y);
        assertThat(biFunction.apply(10, 5)).isEqualTo(15);

        // 메서드 참조
        BiFunction<Integer, Integer, Integer> reference = mathUtils::plus;  // 함수 객체가 받는 인수 (x,y), 참조되는 메서드 인수 (x,y) 동일
        assertThat(reference.apply(10, 5)).isEqualTo(15);
    }

    @Test
    @DisplayName("비한정적(인스턴스) 메서드 참조")
    void 비한정적_인스턴스_메서드_참조() {
        // 매번 다른 객체가 들어오는 경우
        List<String> names = List.of("ZAYSON", "MAENG", "JOON", "YOUNG");
        names.stream().map(name -> name.toLowerCase()).forEach(System.out::println);

        Set<String> cities = Set.of("SEOUL", "BUNDANG", "BUSAN");
        cities.stream().map(city -> city.toLowerCase()).forEach(System.out::println);

        // str -> str.toLowerCase() 할때마다 str에 넘어오는 인자가 매번 다르다.
        names.stream().map(String::toLowerCase).forEach(System.out::println);
        cities.stream().map(String::toLowerCase).forEach(System.out::println);
    }

    @Test
    @DisplayName("클래스 생성자 메서드 참조")
    void 클래스_생성자_참조() {
        Function<Integer, MathUtils> function = MathUtils::new;
        assertThat(function.apply(10).plusWithDefaultNumber(5, 5)).isEqualTo(20);
    }

    @Test
    @DisplayName("배열 생성자 메서드 참조")
    void 배열_생성자_메서드_참조() {
        int[] array1 = new int[5];

        Function<Integer, int[]> function = int[]::new;
        assertThat(function.apply(10).length).isEqualTo(10);
    }
}
