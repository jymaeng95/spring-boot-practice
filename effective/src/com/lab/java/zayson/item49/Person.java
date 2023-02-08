package com.lab.java.zayson.item49;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        // Java 7의 Objects.requireNonNull을 이용해 파라미터 검사 (예외 메세지를 넘길 수 있음)
        this.name = Objects.requireNonNull(name, "예외 메세지 : 이름이 없을 수 없다.");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 아이와 어른의 나이의 합을 계산한다.
     *
     * @param child 어린이 Person 객체
     * @param adult 어른 Person 객체
     * @return 어린이와 어른을 합친 나이
     * @throws IllegalArgumentException 나이가 0보다 작거나 같은 경우
     */
    public int calculateAges(Person child, Person adult) {
        // 입력 매개변수에 대한 검사 수행
        if(child.getAge() <= 0 || adult.getAge() <= 0)
            throw new IllegalArgumentException("나이는 0살 보다 작을 수 없습니다.");  // 예외를 @thorws JavaDoc을 통해 명시

        // 입력 매개변수 검사 후 메서드 몸체 수행
        return child.age + adult.age;
    }

    // Helper Method
    private static void validName(String name) {
        assert name != null;
        assert name.length() > 0;

        System.out.println("name = " + name);
    }
}
