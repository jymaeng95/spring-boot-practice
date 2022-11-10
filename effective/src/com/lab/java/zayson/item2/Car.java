package com.lab.java.zayson.item2;

/**
 * 점층적 생성자 패턴 : 필수 파라미터 -> 필수 파라미터 + 선택 파라미터를 모두 받는 생성자로 늘려가는 방식
 */
public class Car {
    private final String company;       // 필수
    private final int year;             // 필수
    private final int weight;           // 선택
    private final int driveDistance;    // 선택
    private final int maxSpeed;         // 선택

    // 필수 파라미터 생성자
    public Car(String company, int year) {
        this(company, year, 0);
    }

    // 필수 파라미터 + 선택적 파라미터
    public Car(String company, int year, int weight) {
        this(company, year, weight, 0);
    }

    public Car(String company, int year, int weight, int driveDistance) {
        this(company, year, weight, driveDistance, 0);
    }

    public Car(String company, int year, int weight, int driveDistance, int maxSpeed) {
        this.company = company;
        this.year = year;
        this.driveDistance = driveDistance;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
    }

    // 최대 속력 초과 시 예외 발생 메서드
    private static final int MAX_SPEED = 200;
    public boolean exceedMaxSpeed() {
        if(this.maxSpeed > MAX_SPEED)
            throw new IllegalArgumentException("최대 속도 초과");

        return true;
    }
}
