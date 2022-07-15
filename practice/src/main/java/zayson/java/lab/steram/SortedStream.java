package zayson.java.lab.steram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

public class SortedStream {
    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("chaeyoung", 26),
                new Person("maeng", 30));

        // sorted : 스트림 데이터를 정렬해 스트림으로 반환 (파라미터 : comparator, Comparable)
        // 이름을 기준으로 오름차순 정렬
        personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        // 나이를 기준으로 내림차순 정렬
        personList.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(System.out::println);
    }
}
