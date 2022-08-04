package zayson.java.lab.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class ReductionStream {
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

        // reduction : 시퀀스가 있는 요소를 작은 값으로 감소시킨다.
        // 파라미터 1개인 경우 (accumulator) -> Optional<T>
        Integer sum = personList.stream()
                .map(Person::getAge)
                .filter(age -> age <= 28)
                .reduce((a, b) -> Integer.sum(a, b)).get();
        System.out.println("sum = " + sum);

        // 파라미터 2개인 경우 (identity, accumulator) -> T
        Integer sum1 = personList.stream()
                .map(Person::getAge)
                .filter(age -> age <= 28)
                .reduce(6, (a, b) -> Integer.sum(a, b));
        System.out.println("sum1 = " + sum1);

        String result = personList.stream()
                .map(Person::getName)
                .reduce((a, b) -> String.join("/", a, b)).get();
        System.out.println("result = " + result);
    }
}
