package com.lab.java.zayson.item5;

import java.util.function.Supplier;

public abstract class Sports {
    public enum SportsType {SOCCER, BASEBALL}

    public abstract int getPlayers();

    // 타입에 맞게 Sports의 하위 구체 클래스 생성
    public static Supplier<? extends Sports> create(SportsType sportsType) {
        if (sportsType == SportsType.SOCCER) return Soccer::new;
        if (sportsType == SportsType.BASEBALL) return Baseball::new;

        throw new IllegalArgumentException("존재 하지 않는 타입");
    }
}
