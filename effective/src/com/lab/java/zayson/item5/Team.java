package com.lab.java.zayson.item5;

import java.util.Objects;
import java.util.function.Supplier;

public class Team {
    // 의존 관계 주입
    private final Sports sports;
    private final String teamName;
    private final String homeGround;

    // 인스턴스 생성 시 자원을 넘겨서 주입
    private Team(Supplier<? extends Sports> sportsFactory, String teamName, String homeGround) {
        this.sports = Objects.requireNonNull(sportsFactory.get());
        this.teamName = teamName;
        this.homeGround = homeGround;
    }

    // 팩토리를 생성자에 넘겨준다.
    public static Team create(Supplier<? extends Sports> sportsFactory, String teamName, String homeGround) {
        return new Team(sportsFactory, teamName, homeGround);
    }

    public Sports getSports() {
        return sports;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getHomeGround() {
        return homeGround;
    }
}
