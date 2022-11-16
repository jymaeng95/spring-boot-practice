package com.lab.java.zayson.item6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String 불변 테스트")
    void String_테스트() {
        // 다른 객체
        String name1 = new String("zayson");
        String name2 = new String("zayson");

        // 동일한 객체
        String name4 = "zayson";
        String name5 = "zayson";


        assertThat(name4).isSameAs(name5);
        assertThat(System.identityHashCode(name4)).isEqualTo(System.identityHashCode(name5));  // 동일한 객체이므로 동일한 해시코드를 가짐

        assertThat(name1).isNotSameAs(name2);
        assertThat(System.identityHashCode(name1)).isNotEqualTo(System.identityHashCode(name2));  // 다른 해시코드를 가짐
    }
}
