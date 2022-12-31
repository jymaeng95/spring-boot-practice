package com.lab.java.zayson.item32;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GenericVarargsTest {
    @Test
    @DisplayName("제너릭 매개변수 배열 참조 노출 문제")
    void 제네릭_매개변수_배열_참조_노출_문제() {
        assertThat(GenericVarargs.pickTo("zayson", "maeng", "chae")).isInstanceOf(String[].class);
    }
}
