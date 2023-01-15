package com.lab.java.zayson.item37;

public enum BadPhase {
    SOLID, LIQUID, GAS;

    public enum BadTransition {
        // 원소가 수정되거나, 추가되는 경우 배열을 같이 컨트롤 해야함
        // ordinal을 순서로 사용하면 컴파일러는 배열의 인덱스와의 관계를 몰라 잘못되더라도 그대로 동작해 버그 발생 가능성 존재
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // 행은 from의 ordinal을, 열은 to의 ordinal을 사용
        private static final BadTransition[][] BAD_TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // 한 상태에서 다른 상태로의 전이를 반환한다.
        public static BadTransition from(BadPhase from, BadPhase to) {
            return BAD_TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
