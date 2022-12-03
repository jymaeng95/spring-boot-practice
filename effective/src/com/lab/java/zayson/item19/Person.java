package com.lab.java.zayson.item19;

public class Person {
    int distance;
    private final String name;
    private final int age;

    public Person(String name, int age) {
        distance = 0;
        this.name = name;
        this.age = age;
    }

    public void walk() {
        distance ++;
    }

    // 상위 클래스에서는 재정의한 메서드를 호출하지 않고 헬퍼 메서드로 추출
    public void stop() {
        // 자기 사용 메서드
        String record = recordHelper();
        System.out.println("record = " + record);
    }

    // private 도우미 메서드로 추출 (현재 클래스에서만 호출 가능)
    private String recordHelper() {
        System.out.println("기록 시작");
        return String.format("이름 : %s, 나이 ; %d, 이동 거리 ; %d", name, age, distance);
    }

    // 하위 클래스에서 재정의 가능한 메서드
    public String record() {
        return "";
    }
}
