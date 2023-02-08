package com.lab.java.zayson.item50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DefensiveCopyTest {
    @Test
    @DisplayName("클라이언트로부터 가변 객체를 전달받은 경우")
    void 클라이언트로부터_가변객체를_전달받은_경우() {
        // 가변 객체
        MutableAddress address = new MutableAddress("Seoul", 12345);

        // Company의 경우 address를 final로 선언
        Company company = new Company("Nexon", address);

        // address의 도시를 변경
        address.setCity("Pangyo");

        assertThat(company.getAddress().getCity()).isEqualTo("Pangyo");
    }

    @Test
    @DisplayName("Getter를 통해 받은 인스턴스에 대한 방어적 복사 필요")
    void 클라이언트에게_가변객체를_전달한_경우() {
        // 가변 객체
        MutableAddress address = new MutableAddress("Seoul", 12345);

        // 생성 시점에는 방어적 복사를 수행하는 생성자 호출
        Company company = new Company(address);
        address.setCity("Pangyo");

        // 생성 시점에 변경 되지 않는 것 확인
        assertThat(company.getAddress().getCity()).isNotEqualTo("Pangyo");

        // 전달 받은 클라이언트가 내부 변경
        company.getAddress().setCity("Pangyo");
    }
}
