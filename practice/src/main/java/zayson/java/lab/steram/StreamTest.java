package zayson.java.lab.steram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 기존 데이터 확인
        initStream();
        
        // 스트림 생성하기
        createStream();

        // 데이터 정렬 후 반복문 돌리기
        sortedStream();
    }

    private static void initStream() {
        List<String> stringList = List.of("zayson", "maeng", "joon");
        Stream<String> stringStream = stringList.stream().sorted();

        // 기존 데이터로부터 생성한 스트림
        System.out.println("-- 스트림 --");
        stringStream.forEach(System.out::println);
        stringStream.filter(string -> string.contains("zayson"))
                .forEach(System.out::println);

        // 기존 데이터
        System.out.println("-- 기존 데이터 --");
        for (String str : stringList)
            System.out.println(str);
    }

    private static void createStream() {
        /**
         * 스트림 생성하기
         */
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> stringList = List.of("zayson", "maeng", "joon");

        IntStream intStream = Arrays.stream(intArray); // 배열의 스트림 생성
        Stream<String> stringStream = stringList.stream();  // 리스트의 스트림

        Map<String, Integer> person = Map.of("zayson", 28, "chaeyoung", 26);
        Stream<Map.Entry<String, Integer>> entryStream = person.entrySet().stream(); // 맵의 EntrySet 스트림 생성

        Set<Integer> integerSet = Set.of(10, 20, 30);
        Stream<Integer> stream = integerSet.stream();   // 셋의 스트림 생성 ->  Integer이므로 Integer 스트림 생성


        // Stream.of 팩토리 메서드로 스트림 생성
        Stream<Integer> integerStream = Stream.of(20, 30);
        Stream<Person> personStream = Stream.of(new Person("zayson", 28), new Person("chaeyoung", 26));
    }

    private static void sortedStream() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> stringList = List.of("zayson", "maeng", "joon");

        Arrays.stream(intArray) // 스트림 생성 (생성하기)
                .sorted()       // 데이터 정렬 (가공하기)
                .filter(x -> x % 2 == 0)    // 조건으로 데이터 가공 (가공하기)
                .forEach(System.out::println);  //

        stringList.stream()
                .sorted()
                .filter(str -> str.contains("o"))       // zayson, maeng
                .forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;

    }
}
