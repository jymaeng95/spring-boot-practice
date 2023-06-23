package com.zayson.jvm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zayson.jvm.domain.FootballClub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    private ObjectMapper mapper;

    @BeforeEach
    void init() {
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("JsonInclude의 ALWAYS 속성 적용")
    @Order(1)
    void include_always() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //given
        FootballClub footBallClub = createFootBallClub(
                FootballClub.Player.builder().name("musiala").build()
        );

        // when
        String result = mapper.writeValueAsString(footBallClub);

        // then
        assertThat(result).contains("clubName");
        assertThat(result).contains("country");

        assertThat(result).contains("players");
        assertThat(result).contains("name");
        assertThat(result).contains("age");
        assertThat(result).contains("sponsor");

        System.out.println("result = " + result);
        // result = {"clubName":"Bayern Munich","country":"Germany","players":[{"name":"musiala","age":0,"sponsor":null}]}
    }

    @Test
    @DisplayName("JsonInclude의 NON_EMPTY 속성 적용")
    @Order(2)
    void include_non_empty() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // given
        FootballClub footBallClub = createFootBallClub(
                FootballClub.Player.builder().name("musiala").build()
        );

        // when
        String result = mapper.writeValueAsString(footBallClub);

        // then
        assertThat(result).contains("clubName");
        assertThat(result).contains("country");

        assertThat(result).contains("players");
        assertThat(result).contains("name");
        assertThat(result).contains("age");
        assertThat(result).doesNotContain("sponsor");

        System.out.println("result = " + result);
        // result = {"clubName":"Bayern Munich","country":"Germany","players":[{"name":"musiala","age":0}]}
    }

    @Test
    @DisplayName("JsonInclude의 NON_DEFAULT 속성 적용")
    @Order(3)
    void include_non_default() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

        // given
        FootballClub footBallClub = createFootBallClub(
                FootballClub.Player.builder().name("musiala").build()
        );

        // when
        String result = mapper.writeValueAsString(footBallClub);

        // then
        assertThat(result).contains("clubName");
        assertThat(result).contains("country");

        assertThat(result).contains("players");
        assertThat(result).contains("name");
        assertThat(result).doesNotContain("age");
        assertThat(result).doesNotContain("sponsor");

        System.out.println("result = " + result);
        // result = {"clubName":"Bayern Munich","country":"Germany","players":[{"name":"musiala"}]}
    }

    @Test
    @DisplayName("JsonGetter로 받아지는 파라미터 비교")
    void json_getter() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // given
        FootballClub footBallClub = createFootBallClub();

        // when
        String result = mapper.writeValueAsString(footBallClub);

        // then
        assertThat(result).contains("hometown");

        System.out.println("result = " + result);
        // result = {"clubName":"Bayern Munich","country":"Germany","hometown":"Munich"}
    }

    @Test
    @DisplayName("JsonSetter로 Deserialize하는 경우")
    void json_setter() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // given
        String jsonString = "{\"clubName\":\"Bayern Munich\",\"country\":\"Germany\",\"hometown\":\"Munich\"}";

        // when
        FootballClub footBallClub = mapper.readValue(jsonString, FootballClub.class);

        // then
        assertThat(footBallClub.getCity()).isEqualTo("Munich");
    }

    @Test
    @DisplayName("JsonIgnore를 지정한 경우 해당 필드는 Serialize/Deserialize 실행 X")
    void jsonIgnore() throws JsonProcessingException {
        // given
        FootballClub footBallClub = createFootBallClub();

        // when
        String result = mapper.writeValueAsString(footBallClub);

        // then
        assertThat(result).doesNotContain("city");

        System.out.println("result = " + result);
    }

    private FootballClub createFootBallClub(FootballClub.Player... player) {
        return FootballClub.builder()
                .clubName("Bayern Munich")
                .country("Germany")
                .city("Munich")
                .players(Arrays.stream(player).toList())
                .build();
    }
}
