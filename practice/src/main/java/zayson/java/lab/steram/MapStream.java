package zayson.java.lab.steram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapStream {
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

        // map : 기존 스트림 -> 새로운 요소의 스트림으로 변환
        personList.stream() // 스트림 생성
                .filter(person -> person.getAge() <= 28)    // 중간 연산 (28살이하)
                .map(Person::getName)   // 객체에서 이름만 추출 : Person -> String Stream으로 변환
                .forEach(System.out::println);

        String[][] name = {{"zayson", "maeng" }, {"violet", "yun" }};

        // flatMap : 스트림 변환 시 시퀀스를 가진 스트림으로 변환되는 경우 flatMap을 사용
        // 기존 map을 이용하는 경우 시퀀스가 있는 {"zayson", "maeng" }, {"violet", "yun" } 스트림으로 변환된다.
        Arrays.stream(name).map(Arrays::stream)
                .forEach(System.out::println);

        // flatMap을 이용하면 단일 스트림으로 변환된다. {"zayson", "maeng", "violet", "yun" }
        Arrays.stream(name).flatMap(Arrays::stream)
                .forEach(System.out::println);

    }
}
