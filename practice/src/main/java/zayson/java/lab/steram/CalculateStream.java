package zayson.java.lab.steram;

import java.util.List;

public class CalculateStream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("caheyoung", 26),
                new Person("maeng", 30),
                new Person("joon", 32)
        );

        // 나이의 총합, 평균 나이, 최대 나이, 최소 나이, 30에 이상 인원 구하기
        // 1) 나이의 총합
        int ageSum = personList.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("나이의 총합 = " + ageSum);

        // 2) 평균 나이
        double ageAvg = personList.stream()
                .mapToInt(Person::getAge)
                .average().getAsDouble();
        System.out.println("평균 나이 = " + ageAvg);

        // 3) 최대 나이
        // 프리미티브 타입
        int maxAge1 = personList.stream()
                .mapToInt(Person::getAge)
                .max().getAsInt();
        System.out.println("원시 타입 (최대나이) = " + maxAge1);

        // 래퍼런스 타입
        Integer maxAge2 = personList.stream()
                .map(Person::getAge)
                .max(Integer::compare)
                .get();
        System.out.println("래퍼런스 타입 (최대나이) = " + maxAge2);

        // 4) 최소 나이
        // 프리미티브 타입
        int minAge1 = personList.stream()
                .mapToInt(Person::getAge)
                .min().getAsInt();
        System.out.println("원시 타입 (최소 나이) = " + minAge1);

        // 래퍼런스 타입
        Integer minAge2 = personList.stream()
                .map(Person::getAge)
                .min(Integer::compare).get();
        System.out.println("원시 타입 (최소 나이) = " + minAge2);

        // 5) 30살 이상 인원 구하기
        long count = personList.stream()
                .map(Person::getAge)
                .filter(age -> age >= 30)
                .count();
        System.out.println("30살 이상 인원 = " + count);
    }
}
