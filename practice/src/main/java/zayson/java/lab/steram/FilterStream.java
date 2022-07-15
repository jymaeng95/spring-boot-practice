package zayson.java.lab.steram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class FilterStream {
    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        // 리스트 생성
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("chaeyoung", 26),
                new Person("maeng", 30));

        // Filter를 이용해 연산 결과 가공하기 (
        personList.stream() // 스트림 생성
                .filter(person -> person.getAge() <= 28)   // 중간 연산 (나이가 28세 이하인 사람만 뽑기)
                .forEach(System.out::println);
    }
}
