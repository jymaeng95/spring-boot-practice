package com.lab.java.zayson.item26;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GenericTest {
    @Test
    @DisplayName("제너릭 타입 및 로 타입 테스트")
    void 제너릭_로타입_테스트() {
        List<Integer> integerList = new ArrayList<>();
//        integerList.add("zayson");

        // 로 타입 선언 (컴파일 단계 에러 파악 불가)
        List rawType = new ArrayList();
        rawType.add(10);
        rawType.add("zayson");

        // Exception 발생
        for (Iterator i = rawType.iterator(); i.hasNext(); ) {
            assertThrows(ClassCastException.class, () -> {
                Double next = (Double) i.next();
            });
        }
    }

    @Test
    @DisplayName("하위 타입 규칙 확인")
    void 하위_타입_안전성() {
        List<String> strings = new ArrayList<>();
        unsafeAddV1(strings, Integer.valueOf(28));
        assertThrows(ClassCastException.class, () -> strings.get(0)); // 컴파일러가 원소 꺼낼때 자동 캐스팅 -> But Exception발생

        // 컴파일 시점에 에러 파악 가능
        List<String> strings1 = new ArrayList<>();
//        unsafeAddV2(strings, Integer.valueOf(28));
    }

    @Test
    @DisplayName("비한정적 와일드카드 타입")
    void 비한정적_와일드카드_타입() {
        // 로 타입의 경우 s1, s2의 타입이 달라도 컴파일 시점에 모른다.
        Set s1 = new HashSet(List.of(1, 2));
        Set s2 = new HashSet(List.of("zayson", "maeng"));
        numElementsInCommonV1(s1, s2);

        Set<?> wildCard = new HashSet<>();
//        wildCard.add(1); // 컴파일 에러
    }


    private static void unsafeAddV1(List list, Object o) {
        list.add(o);
    }

    private static void unsafeAddV2(List<Object> list, Object o) {
        list.add(o);
    }

    // 파라미터로 로 타입을 사용하는 경우 안전하지 않음
    static int numElementsInCommonV1(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }

        }
        return result;
    }

    // 어떤 타입의 Set이 들어올지 모르기 때문에 신경쓰지 않음
    static int numElementsInCommonV2(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }

        }
        return result;
    }
}
