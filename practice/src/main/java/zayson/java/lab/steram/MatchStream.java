package zayson.java.lab.steram;

import java.util.List;

public class MatchStream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("caheyoung", 26),
                new Person("maeng", 30),
                new Person("joon", 32)
        );

        // 1) 이름에 z가 한명이라도 들어가는 경우
        boolean anyMatch = personList.stream().anyMatch(person -> person.getName().contains("z"));

        // 2) 나이가 모드 25살 이상인 경우
        boolean allMatch = personList.stream().allMatch(person -> person.getAge() >= 25);

        // 3) 이름이 모두 10글자 이상인 경우
        boolean noneMatch = personList.stream().noneMatch(person -> person.getName().length() >= 10);

        System.out.println("anyMatch = " + anyMatch);
        System.out.println("allMatch = " + allMatch);
        System.out.println("noneMatch = " + noneMatch);
    }
}
