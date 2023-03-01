package com.lab.java.zayson.item61;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoxingTypeTest {
    @Test
    @DisplayName("박싱된 기본 타입을 ==으로 비교하는 경우 발생하는 오류")
    void 박싱된_기본_타입_비교_오류() {
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        Integer first = new Integer(29);
        Integer second = new Integer(29);

        // 값이 동일하다고 판단하지 않음
        assertThat(naturalOrder.compare(first, second)).isNotEqualTo(0);
    }

    @Test
    @DisplayName("오토 박싱을 이용한 비교")
    void 오토박싱을_이용한_동일성_비교() {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return (i < j) ? -1 : (i == j ? 0 : 1);
        };

        Integer first = new Integer(29);
        Integer second = new Integer(29);

        assertThat(naturalOrder.compare(first, second)).isEqualTo(0);
    }

    @Test
    @DisplayName("박싱과 언박싱으로 인한 효율성 저하")
    void 박싱과_언박싱으로_인한_효율성_저하() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
