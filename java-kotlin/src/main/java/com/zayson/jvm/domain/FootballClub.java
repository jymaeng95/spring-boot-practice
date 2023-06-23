package com.zayson.jvm.domain;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FootballClub {
    private String clubName;
    private String country;
    private List<Player> players;

    @JsonIgnore
    private String city;

    @JsonGetter("hometown")
    public String getCity() {
        return city;
    }

    @JsonSetter("hometown")
    public void setCity(String city) {
        this.city = city;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Player {
        private String name;
        private int age;
        private String sponsor;
    }
}
