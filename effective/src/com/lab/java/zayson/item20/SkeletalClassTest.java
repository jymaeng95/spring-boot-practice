package com.lab.java.zayson.item20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SkeletalClassTest {
    @Test
    @DisplayName("추상 골격 구현 클래스 테스트")
    void 추상_골격_구현_클래스_테스트() {
        int[] arr = {1, 2, 3};
        List<Integer> list = CustomUtil.intArrayAsList(arr);

        // 새롭게 구현한 System 로그 찍힘
        Integer oldVal = list.set(0, 5);
        Integer value = list.get(0);
        int size = list.size();

        Assertions.assertThat(oldVal).isEqualTo(1);
    }
}
