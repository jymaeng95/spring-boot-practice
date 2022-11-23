package com.lab.java.zayson.item12;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PersonTest {
    @Test
    @DisplayName("toString 오버라이딩 출력")
    void toString_오버라이딩_안한경우() {
        PersonV1 person = new PersonV1(28, "zayson");

        assertThat(person.toString().startsWith(person.getClass().getName())).isTrue();
    }

    @Test
    @DisplayName("toString 오버라이딩 출력")
    void toString_오버라이딩() {
        PersonV2 person = new PersonV2(28, "zayson");

        System.out.println("person.toString() = " + person.toString());
    }

    @Test
    @DisplayName("toString의 반환 값 API 제공")
    void toString의_반환값_API() {
        PersonV2 person = new PersonV2(28, "zayson");
        System.out.println("person.toString() = " + person.toString());

        // getter를 이용해 toString의 반환값 제공
        int age = person.getAge();
        String name = person.getName();

        assertThat(age).isEqualTo(28);
        assertThat(name).isEqualTo("zayson");
    }
}