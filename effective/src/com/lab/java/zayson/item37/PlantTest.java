package com.lab.java.zayson.item37;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PlantTest {
    @Test
    @DisplayName("[좋지않은 코드] Ordinal을 이용한 배열 인덱싱")
    void ordinal을_이용한_배열_인덱싱() {
        // 비검사 형변환 경고 발생 (타입 안전하지 않음)
        @SuppressWarnings("unchecked")
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int index = 0; index < plantsByLifeCycle.length; index++) {
            plantsByLifeCycle[index] = new HashSet<>();
        }

        // 배열 인덱스로 사용 (ordinal)
        for (Plant plant : makeGarden()) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        System.out.println("plantsByLifeCycle = " + Arrays.toString(plantsByLifeCycle));
    }

    @Test
    @DisplayName("EnumMap을 사용하는 경우")
    void enumMap을_사용하는_경우() {
        // 열거형 타입을 맵에 넣어줌
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        // 타입별로 Set 선언
        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant plant : makeGarden()) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        System.out.println("plantsByLifeCycle = " + plantsByLifeCycle.toString());
    }


    private static List<Plant> makeGarden() {
        return List.of(
                new Plant("tree", Plant.LifeCycle.BIENNIAL),
                new Plant("flower", Plant.LifeCycle.ANNUAL),
                new Plant("tree 2", Plant.LifeCycle.PERENNIAL),
                new Plant("flower 2", Plant.LifeCycle.PERENNIAL)
        );
    }
}
