package zayson.java.lab.steram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DistinctStream {
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
                new Person("zayson", 28));

        // 객체는 .equals로 중복을 제거한다.
        personList.stream().distinct()
                .forEach(System.out::println);

        // 원시타입 스트림의 경우 == 으로 값을 비교한다.
        int[] ints = {9, 1, 1, 0, 2, 5, 9, 1, 0};
        Arrays.stream(ints)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        List<Integer> integerList = List.of(0, 1, 1, 0, 2, 5, 9, 1, 0);

        integerList.stream().distinct().sorted()
                .forEach(x -> System.out.print(x + " "));
    }
}
