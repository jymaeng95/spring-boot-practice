package com.lab.java.zayson.item37;

import java.awt.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase {
    // 상태
    SOLID, LIQUID, GAS;

    public enum Transition {
        // 이전 상태 -> 이후 상태
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // 맵의 초기화 (EnumMap으로 이전상태와 이후 상태를 대응)
        private static final Map<Phase, Map<Phase, Transition>> map =
                Stream.of(values())
                        .collect(Collectors.groupingBy(
                                t -> t.from,
                                () -> new EnumMap<>(Phase.class),
                                Collectors.toMap(
                                        t -> t.to,
                                        t -> t,
                                        (x, y) -> y,
                                        () -> new EnumMap<>(Phase.class)
                                )
                        ));
    }
}
