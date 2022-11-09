package com.lab.java.zayson.item1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class SpaceTest {
    @Test
    @DisplayName("정적 팩토리 메서드는 이름을 가질 수 있다.")
    void 네이밍_가능() {
        // 동일한 시그니처의 다른 이름 생성
        Space cafe = Space.newCafe("분당", "중앙공원로", 5);
        Space company = Space.newCompany("판교", "대왕판교로", 20);

        // 생성자는 동일한 시그니처는 하나밖에 안된다.
        Space space = new Space("도시", "거리", 5);

        assertThat(cafe).isInstanceOf(Space.class);
        assertThat(company).isInstanceOf(Space.class);
        assertThat(space).isInstanceOf(Space.class);
    }

    @Test
    @DisplayName("정적 팩토리 메서드는 호출될 때 마다 새로운 인스턴스를 생성하지 않아도 된다.")
    void 동일한_인스턴스_빈환() {
        Space firstSpace = Space.valueOf();
        Space secondSpace = Space.valueOf();

        assertThat(firstSpace).isSameAs(secondSpace);
        assertThat(firstSpace == secondSpace).isTrue();
    }

    @Test
    @DisplayName("정적 팩토리 메서드는 하위 타입을 반환하고 매개변수에 따라 다른 객체를 반환하는 것이 가능하다.")
    void 하위타입_인스턴스_반환() {
        Space cafe = Space.getSpaceByType("cafe");
        Space company = Space.getSpaceByType("company");

        assertThat(cafe).isInstanceOf(Cafe.class);
        assertThat(company).isInstanceOf(Company.class);
    }
}