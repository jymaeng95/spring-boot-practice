package com.lab.java.zayson.item18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

class CompositionTest {
    @Test
    @DisplayName("addCount 개수 확인")
    void addCount() {
        InstrumentedHashSetV1<Integer> set = new InstrumentedHashSetV1<>();
        set.addAll(List.of(1, 2, 3));

        assertThat(set.getAddCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("컴포지션을 이용한 addCount")
    void addCount_with_Composition() {
        // Set 인터페이스 타입의 인스턴스를 갖는 래퍼 클래스 -> Set의 실제 여러 구현체로 래퍼클래스 이용 가능
        InstrumentedHashSet<Integer> treeSet = new InstrumentedHashSet<>(new TreeSet<>());
        InstrumentedHashSet<Integer> hashSet = new InstrumentedHashSet<>(new HashSet<>());

        hashSet.addAll(List.of(4, 3, 2));
        treeSet.addAll(List.of(4, 3, 2));

        assertThat(hashSet.getAddCount()).isEqualTo(3);
        assertThat(treeSet.getAddCount()).isEqualTo(3);
    }
}