package com.lab.java.zayson.item14;

import java.util.Comparator;

import static java.util.Comparator.*;

public class PersonV2 implements Comparable<PersonV2> {
    private final String name;
    private final int age;
    private final int height;

    public PersonV2(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // 2. 메서드 체이닝 방식
    private static final Comparator<PersonV2> COMPARATOR =
            comparing((PersonV2 p) -> p.name)   // 1. 이름으로 비교
                    .thenComparingInt(p -> p.age)   // 2. 나이로 비교
                    .thenComparingInt(p -> p.height);   // 3. 키로 비교
    @Override
    public int compareTo(PersonV2 o) {
        // comapreTo에는 비교자 생성 메서드를 이용
        return COMPARATOR.compare(this, o);
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
