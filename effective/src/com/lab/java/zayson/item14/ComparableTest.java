package com.lab.java.zayson.item14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ComparableTest {
    @Test
    @DisplayName("Comparable의 eqauls와 일관되게 하지 않는 경우의 예시")
    void compareTo_eqauls가_일관되지_않은_경우() {
        // BigDecimal은 compareTo, equals가 일관되지 않다.
        BigDecimal one = new BigDecimal("1.0");
        BigDecimal two = new BigDecimal("1.00");

        // HashSet의 경우 equals로 동치성 비교 (서로 다르기 때문에 2개)
        Set<BigDecimal> hashSet = new HashSet<>(List.of(one, two));
        assertThat(hashSet.size()).isEqualTo(2);

        // TreeSet의 경우 compareTo로 동치성 비교 (크기가 동일하므로 동일하다 판단)
        Set<BigDecimal> treeSet = new TreeSet<>(List.of(one, two));
        assertThat(treeSet.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("래퍼 클래스 compare 정적 메서드를 이용한 비교")
    void compare_정적_메서드_비교() {
        Coffee iceAmericano = new Coffee(2500, "Ice Americano");
        Coffee latte = new Coffee(3000, "Ice Latte");
        Coffee espresso = new Coffee(4000, "Espresso");

        // 가격순으로 비교가 되는지 확인
        List<Coffee> coffeeList = new ArrayList<>(List.of(iceAmericano, latte, espresso));
        Collections.sort(coffeeList);

        assertThat(coffeeList.get(0).getPrice()).isLessThan(coffeeList.get(1).getPrice());
        assertThat(coffeeList.get(1).getPrice()).isLessThan(coffeeList.get(2).getPrice());
        assertThat(coffeeList.get(0).getPrice()).isLessThan(coffeeList.get(2).getPrice());
    }

    @Test
    @DisplayName("핵심 필드가 여러개인 경우 비교 방법 V1 : 조건문을 이용한 순차적인 비교")
    void 핵심필드_여러개_비교_V1() {
        PersonV1 person1 = new PersonV1("zayson", 28, 184);
        PersonV1 person2 = new PersonV1("zayson", 28, 180);
        PersonV1 person3 = new PersonV1("zayson", 30, 170);
        PersonV1 person4 = new PersonV1("maeng", 30, 160);

        List<PersonV1> people = new ArrayList<>(List.of(person1, person2, person3, person4));

        System.out.println("순서 정렬 전 : " + people.toString());
        Collections.sort(people);
        System.out.println("순서 정렬 후 : " + people.toString());
    }

    @Test
    @DisplayName("핵심 필드가 여러개인 경우 비교 방법 V2 : 비교자 생성 메서드를 이용한 체이닝 방식")
    void 핵심필드_여러개_비교_V2() {
        PersonV2 person1 = new PersonV2("zayson", 28, 184);
        PersonV2 person2 = new PersonV2("zayson", 28, 180);
        PersonV2 person3 = new PersonV2("zayson", 30, 170);
        PersonV2 person4 = new PersonV2("maeng", 30, 160);

        List<PersonV2> people = new ArrayList<>(List.of(person1, person2, person3, person4));

        System.out.println("순서 정렬 전 : " + people.toString());
        Collections.sort(people);
        System.out.println("순서 정렬 후 : " + people.toString());
    }
}
