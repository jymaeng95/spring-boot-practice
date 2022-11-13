package com.lab.java.zayson.item5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lab.java.zayson.item5.Sports.SportsType.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    @Test
    @DisplayName("팩토리를 생성자에 넘겨서 의존관계 주입이 가능하다.")
    void 팩토리_생성자_주입() {
        // 팩토리를 이용해 스포츠 타입에 맞는 구체 클래스 주입
        Team soccerTeam = Team.create(Sports.create(SOCCER), "Manchester City", "Manchester");
        Team baseballTeam = Team.create(Sports.create(BASEBALL), "NY Yankees", "New York");

        // T extends Sports -> Sports의 하위 타입
        Team arsenal = Team.create(Soccer::new, "Arsenal", "London");

        assertThat(soccerTeam.getSports()).isInstanceOf(Soccer.class);
        assertThat(soccerTeam.getSports().getPlayers()).isEqualTo(11);

        assertThat(baseballTeam.getSports()).isInstanceOf(Baseball.class);
        assertThat(baseballTeam.getSports().getPlayers()).isEqualTo(10);

        assertThat(arsenal.getSports()).isInstanceOf(Soccer.class);
    }
}