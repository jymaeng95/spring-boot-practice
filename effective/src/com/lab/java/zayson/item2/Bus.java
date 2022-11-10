package com.lab.java.zayson.item2;

/**
 * 자바 빈즈 패턴 : Setter를 이용해 값을 주입하고 이를 통해 객체를 생성하는 방법'
 */
public class Bus {
    private String company;       // 필수
    private int year;             // 필수
    private int weight;           // 선택
    private int driveDistance;    // 선택
    private int maxSpeed;         // 선택

    public void setCompany(String company) {
        this.company = company;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDriveDistance(int driveDistance) {
        this.driveDistance = driveDistance;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // 최대 속력 초과 시 예외 발생 메서드
    private static final int MAX_SPEED = 150;
    public boolean exceedMaxSpeed() {
        if(this.maxSpeed > MAX_SPEED)
            throw new IllegalArgumentException("최대 속도 초과");

        return true;
    }
}
