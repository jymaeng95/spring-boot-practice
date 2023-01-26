package com.lab.java.zayson.item42;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LambdaTest {
    @Test
    @DisplayName("익명 클래스로 숫자 정렬")
    void 익명_클래스로_숫자_정렬() {
        List<Integer> numbers = Arrays.asList(10, 29, 30, 1, 3, 5, 203, 4, -1, 93);

        // 익명 클래스로 정렬
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        assertThat(numbers.get(0)).isEqualTo(-1);
    }

    @Test
    @DisplayName("람다로 숫자 정렬")
    void 람다로_숫자_정렬() {
        List<Integer> numbers = Arrays.asList(10, 29, 30, 1, 3, 5, 203, 4, -1, 93);

        // 람다로 정렬
        Collections.sort(numbers, (n1, n2) -> Integer.compare(n1, n2));

        // 비교자 생성 메서드 이용 가능
        Collections.sort(numbers, Integer::compare);

        // Java 8의 list.sort이용 가능
        numbers.sort(Integer::compare);

        assertThat(numbers.get(0)).isEqualTo(-1);
    }

    @Test
    @DisplayName("람다를 인스턴스 필드에 저장후 상수로 계산")
    void 람다를_인스턴스_필드에_저장후_상수로_계산() {
        double x = 10;
        double y = 2;

        assertThat(Operation.DIVIDE.apply(x, y)).isEqualTo(5.0);
    }
}
