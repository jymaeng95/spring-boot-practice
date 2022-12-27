package com.lab.java.zayson.item30;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class IdentityFunction {
    // UnarayOperator T 타입으로 동일한 T타입 객체 리턴
    // 제너릭 싱글톤
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    // UnaryOperator 동일한 T 타입을 전달받아 T 타입을 리턴 = 타입 안정적
    @SuppressWarnings("unchecked")
    private static <T> UnaryOperator<T> identityFunction() {

        // T 와 Object 타입이 다르므로 타입관련 비검사 경고 발생
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] s1 = {"zayson", "maeng"};
        UnaryOperator<String> strings = identityFunction();

        // 타입 안정적이므로 컴파일 에러나지않음
        Arrays.stream(s1).forEach(strings::apply);

        Number[] n1 = {28, 10L};
        UnaryOperator<Number> numbers = identityFunction();
        Arrays.stream(n1).forEach(numbers::apply);
    }
}
