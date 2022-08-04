package zayson.java.lab.stream;


import java.util.List;

public class LimitStream {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("zayson", 28),
                new Person("caheyoung", 26),
                new Person("maeng", 30),
                new Person("joon", 32)
        );

        // 4개의 데이터 중 최대 2개까지 제한한다.
        personList.stream()
                .limit(2)
                .forEach(System.out::println);

        personList.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}

