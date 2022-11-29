package com.lab.java.zayson.item14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

public class WordList {
    @Test
    @DisplayName("String은 Comparable을 구현")
    void String은_Comparable을_기본적으로_구현() {
        // String은 comparable을 구현하기 때문에 TreeSet 같은 비교하는 컬렉션을 사용시 잘 어울림
        TreeSet<String> wordSet = new TreeSet<>(List.of("zayson", "maeng", "kim"));

        assertThat(wordSet.first()).isEqualTo("kim");
    }
}
