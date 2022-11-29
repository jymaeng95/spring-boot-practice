package com.lab.java.zayson.item14;

public class PersonV1 implements Comparable<PersonV1> {
    private final String name;
    private final int age;
    private final int height;

    public PersonV1(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // 1. 조건문을 통한 반복적 비교
    @Override
    public int compareTo(PersonV1 o) {
        // 핵심 필드 이름 -> 나이 -> 키 순서
        if(this.name.equals(o.name)) {
            if(this.age == o.age)
                // 3. 이름과 나이가 동일한 경우 키로 비교
                return Integer.compare(this.height, o.height);
            // 2. 이름이 동일한 경우 나이 순서 비교
            return Integer.compare(this.age, o.age);
        }

        // 1. 이름 순서 비교
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
