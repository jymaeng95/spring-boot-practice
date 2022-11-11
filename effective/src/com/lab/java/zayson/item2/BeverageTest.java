package com.lab.java.zayson.item2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lab.java.zayson.item2.Ade.Fruit.*;
import static com.lab.java.zayson.item2.Beverage.Size.*;
import static com.lab.java.zayson.item2.Coffee.Type.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    @Test
    @DisplayName("빌더 패턴 : 계층적 구조 클래스 테스트")
    void 계층적_구조_클래스_빌더() {
        // 커피를 주문하는 경우
        Coffee coffee = new Coffee.Builder(VENTI, "Americano", 4500, ICE).addShot(true).addSyrup(false).build();

        //  ADE를 주문하는 경우
        Ade ade = new Ade.Builder(GRANDE, "Ade", 6000, ORANGE).build();

        // Beverage 클래스를 상속받아 유연하게 생성한 객체 = Beverage의 인스턴스
        assertThat(coffee).isInstanceOf(Beverage.class);
        assertThat(ade).isInstanceOf(Beverage.class);
    }
}