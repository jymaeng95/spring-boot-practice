package com.lab.java.zayson.item17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ImmutableTest {
    @Test
    @DisplayName("불변 클래스 생성 테스트")
    void 불변_클래스_생성_테스트() {
        Complex complex1 = Complex.valueOf(1.0, 2.0);
        Complex complex2 = Complex.valueOf(2.0, 1.0);

        Complex plus = complex1.plus(complex2);

        // complex1에 덧셈을 한다고 생각하지만 새로운 객체로 생성되어 리턴
        assertThat(complex1).isNotSameAs(plus);
        assertThat(complex1.realPart()).isEqualTo(1.0);
        assertThat(complex1.imaginaryPart()).isEqualTo(2.0);
    }
}
