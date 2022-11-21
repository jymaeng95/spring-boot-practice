package com.lab.java.zayson.item10;

import java.util.Objects;

public class MyStringV2 {
    private final String s;

    public MyStringV2(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        // 일반 String 값에 대한 비교는 못한다.
        return o instanceof MyStringV2 && ((MyStringV2) o).s.equalsIgnoreCase(s);
    }
}
