package com.lab.java.zayson.item35;

public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4);

    // 인스턴스 필드를 이용해 상수 접근
    private final int numberOfMusicians;

    Ensemble(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    // Ordrinal을 이용한 상수 접근(사실상 순서로 접근 -> 상수 순서가 변경되는 경우 이슈 발생)
    public int numberOfMusicians() {
        return ordinal() + 1;
    }

    // 인스턴스 필드 Getter를 통한 접근
    public int getNumberOfMusicians() {
        return numberOfMusicians;
    }
}
