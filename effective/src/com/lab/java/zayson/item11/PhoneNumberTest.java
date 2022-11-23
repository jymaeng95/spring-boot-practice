package com.lab.java.zayson.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PhoneNumberTest {
    @Test
    @DisplayName("해시코드가 구현되지 않은 경우 컬렉션 확인")
    void 해시코드가_구현되지_않은_경우() {
        PhoneNumberV1 phoneNumber1 = new PhoneNumberV1(82, 123, 4567);
        PhoneNumberV1 phoneNumber2 = new PhoneNumberV1(82, 123, 4567);

        // 논리적 동치
        assertThat(phoneNumber1.equals(phoneNumber2)).isTrue();
        assertThat(phoneNumber1.hashCode()).isNotEqualTo(phoneNumber2.hashCode());  // 동일한 결과가 나올 수도 있음

        // 해시코드가 구현되지 않은 경우 컬렉션(해시맵)은 동치성 비교를 하지않도록 최적화
        Map<PhoneNumberV1, String> map = new HashMap<>();
        map.put(phoneNumber1, "동일");

        assertThat(map.get(phoneNumber2)).isNull();
    }

    @Test
    @DisplayName("해시코드가 구현된 경우 컬렉션 확인")
    void 해시코드가_구현된_경우() {
        PhoneNumberV2 phoneNumber1 = new PhoneNumberV2(82, 123, 4567);
        PhoneNumberV2 phoneNumber2 = new PhoneNumberV2(82, 123, 4567);

        // 논리적 동치
        assertThat(phoneNumber1).isEqualTo(phoneNumber2);
        assertThat(phoneNumber1.hashCode()).isEqualTo(phoneNumber2.hashCode());

        Map<PhoneNumberV2, String> map = new HashMap<>();
        map.put(phoneNumber1, "해시코드 구현");

        // 해시코드가 구현되어 동치인 인스턴스 엔트리로 판단
        assertThat(map.get(phoneNumber2)).isNotNull();
        assertThat(map.get(phoneNumber2)).isEqualTo("해시코드 구현");
    }
}