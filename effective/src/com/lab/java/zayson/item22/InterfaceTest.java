package com.lab.java.zayson.item22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterfaceTest {
    @Test
    @DisplayName("상수 인터페이스는 안티 패턴 ")
    void 상수_인터페이스() {
        // 클라이언트 코드에서는 상수 인터페이스를 구현하던지 상관 없이 접근 가능해 구현한 이유에 대한 혼란 가능
        double avogadros1 = Constants.getHalfAvogadros();
        double avogadros2 = Constants.AVOGADROS_NUMBER;
        double avogadros3 = PhysicalConstants.AVOGADROS_NUMBER;

        double value = ConstantsV1.AVO_NUMBER.getValue();
    }
}
