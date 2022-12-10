package com.lab.java.zayson.item22;

public class Constants implements PhysicalConstants {
    // 상수 인터페이스를 구현하는 경우 같은 이름의 상수를 갖는 경우 로직의 혼동 가능성 존재
    public static final double AVOGADROS_NUMBER = 1.0;
    public static double getHalfAvogadros() {

        /**
         * 1. AVOGADROS_NUMBER의 출처를 알 수 없음
         * 2. 외부 인터페이스를 직접 접근하는 것이 아닌 implements로 구현한 내부 구현
         * 3. 클라이언트 코드에서는 어떤 상수 인터페이스를 사용하던 상관 없어 혼란 가능
         * 4. 상수 인터페이슥 구현 클래스가 상수에 종속됨 -> 다음 릴리즈에서 상수를 사용하지 않더라도, 직렬화/역직렬화 과정의 바이너리 호환성을 위해 인터페이스 구현 필요
         *
         */
        return AVOGADROS_NUMBER;
    }
}
