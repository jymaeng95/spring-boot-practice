package com.lab.java.zayson.item38;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OperationTest {
    @Test
    @DisplayName("Enum Class 리터럴을 넘기고, 인터페이스의 하위 타입임을 검증해서 파라미터를 넘김")
    void enum_class_리터럴을_넘기는_방식() {
        double x = 10;
        double y = 5;

        List<Double> basicResults = resultsOf(BasicOperation.class, x, y);  // 사칙연산 열거 타입 예상 결과 4
        List<Double> extendResults = resultsOf(ExtendOperation.class, x, y); // 지수, 나머지 연산 열거 타입 예상 결과 2

        assertThat(basicResults.size()).isEqualTo(4);
        assertThat(extendResults.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("한정적 와일드카드를 이용해 Operation인터페이스의 하위 열거 타입 원소를 파라미터로 넘긴 결과")
    void 한정적_와일드카드_타입을_사용한_예제() {
        double x = 10, y = 5;

        List<Double> basicResults = resultsOf(List.of(BasicOperation.values()), x, y);
        List<Double> extendResults = resultsOf(List.of(ExtendOperation.values()), x, y);

        assertThat(basicResults.size()).isEqualTo(4);
        assertThat(extendResults.size()).isEqualTo(2);
    }
    /**
     * Operation 인터페이스의 하위 타입이고, Enum 타입인 클래스 리터럴을 넘겨야 한다.
     * @param operationType Operation 인터페이스 하위 타입 And Enum 타입
     * @param x 숫자 1
     * @param y 숫자 2
     * @return 결과 리스트
     * @param <T>
     */
    private <T extends Enum<T> & Operation> List<Double> resultsOf(Class<T> operationType, double x, double y) {
        ArrayList<Double> results = new ArrayList<>();
        for (Operation operation : operationType.getEnumConstants()) {
            results.add(operation.apply(x, y));
        }

        return results;
    }

    /**
     * Operation의 하위 타입 원소들을 넘겨 계산한 결과값 리스트를 반환
     * @param operations Operation의 하위 타입 원소
     * @param x 값1
     * @param y 값2
     * @return List<Double> </Double>
     */
    private List<Double> resultsOf(Collection<? extends Operation> operations, double x, double y) {
        List<Double> results = new ArrayList<>();
        for (Operation operation : operations) {
            results.add(operation.apply(x, y));
        }

        return results;
    }
}
