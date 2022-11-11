package com.lab.java.zayson.item2;

/**
 * builder 패턴
 */
public class Truck {
    private final String company;       // 필수
    private final int year;             // 필수
    private final int weight;           // 선택
    private final int driveDistance;    // 선택
    private final int maxSpeed;         // 선택

    private Truck(Builder builder) {
        this.company = builder.company;
        this.year = builder.year;
        this.weight = builder.weight;
        this.driveDistance = builder.driveDistance;
        this.maxSpeed = builder.maxSpeed;
    }

    // 정적 멤버 클래스로 Builder 클래스 정의
    public static class Builder {
        private final String company;  // 필수
        private final int year;        // 필수
        private int weight;           // 선택
        private int driveDistance;    // 선택
        private int maxSpeed;         // 선택

        // 1. 필수 파라미터만으로 생성자를 호출해 빌더 객체를 얻는다.
        public Builder(String company, int year) {
            this.company = company;
            this.year = year;
        }

        // 2. 세터 메서드를 이용해 선택 파라미터를 설정
        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder driveDistance(int driveDistance) {
            this.driveDistance = driveDistance;
            return this;
        }

        public Builder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        // 3. build 메서드를 통해 실제 객체 획득
        public Truck build() {
            return new Truck(this);
        }
    }

    public String getCompany() {
        return company;
    }

    public int getYear() {
        return year;
    }

    public int getWeight() {
        return weight;
    }

    public int getDriveDistance() {
        return driveDistance;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
