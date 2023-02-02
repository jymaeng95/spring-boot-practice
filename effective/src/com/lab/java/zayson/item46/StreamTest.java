package com.lab.java.zayson.item46;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamTest {
    @Test
    @DisplayName("스트림을 통한 단어 빈도 조회")
    void 스트림을_통한_단어_빈도_조회() {
        List<String> words = List.of("zayson", "maeng", "joon", "maeng", "test", "zayson");

        // 잘못 사용한 스트림
        Map<String, Long> freq = new HashMap<>();
        words.forEach(word -> freq.merge(word.toLowerCase(), 1L, Long::sum));

        // 제대로 사용한 스트림 (List -> Map으로 변경하는 것)
        Map<String, Long> collect = words.stream().collect(groupingBy(String::toLowerCase, counting()));
        System.out.println("collect.toString() = " + collect.toString());
    }

    @Test
    @DisplayName("Collector의 대표적인 세가지")
    void Collector_메서드_예제() {
        List<String> words = List.of("zayson", "maeng", "joon", "maeng", "test", "zayson");
        // toList : 주어진 단어의 길이들을 리스트로 반환
        List<Integer> length = words.stream().map(String::length).collect(toList());
        System.out.println("length.toString() = " + length.toString());

        // toSet : 주어진 단어의 첫글자를 Set으로 변환
        Set<Character> firstCharSet = words.stream().map(word -> word.charAt(0)).collect(toSet());
        System.out.println("firstCharSet = " + firstCharSet.toString());

        // toCollection : Collection으로 받기
        Collection<Character> linkedSet = words.stream().map(word -> word.charAt(0)).collect(toCollection(LinkedHashSet::new));

        // 46-3
        Map<String, Long> map = words.stream().collect(groupingBy(String::toLowerCase, counting()));
        List<String> wordList = map.keySet().stream()
                .sorted(comparing(map::get).reversed())
                .limit(3)
                .collect(toList());
    }

    @Test
    @DisplayName("toMap 예제")
    void toMap_예제() {
        List<String> names = List.of("zayson", "maeng", "joon", "young");

        // toMap 인자 2개인 경우 : 첫번째 글자를 대문자로 변경 후 키로 하고 값으로는 이름을 넣어주는 맵
        Map<Character, String> capitalMap = names.stream().collect(toMap(name -> name.toUpperCase().charAt(0), name -> name));
        System.out.println("capitalMap = " + capitalMap);

        // toMap 인자 3개인 경우 : 첫번째 글자를 대문자로 변경 후 키로 하고 값으로는 이름을 넣어주며, 키가 동일한 경우 문자의 길이를 통해 판단
        List<String> names2 = List.of("zayson", "maeng", "joon", "young", "zion williams");
        Map<Character, String> capitalMap2 = names2.stream()
                .collect(toMap(
                        name -> name.toUpperCase().charAt(0),
                        name -> name,
                        BinaryOperator.maxBy(comparing(String::length)) // 문자열 길이가 긴 것을 값으로 취함
                ));
        System.out.println("capitalMap2 = " + capitalMap2);

        // toMap 인자 3개인 경우 : 최신 값으로 값을 대치
        Map<Character, String> capitalMap3 = names2.stream()
                .collect(toMap(
                        name -> name.toUpperCase().charAt(0),
                        name -> name,
                        (oldValue, newValue) -> newValue // 예전 값과 현재 값 중 최신 값으로 대체
                ));
        System.out.println("capitalMap3 = " + capitalMap3);

        // toMap 인자 4개인 경우 : 마지막 인자에 실제 컬렉션 구현체를 지정 가능
        Map<Character, String> capitalMap4 = names2.stream()
                .collect(toMap(
                        name -> name.toUpperCase().charAt(0),
                        name -> name,
                        (oldVal, newVal) -> newVal,
                        HashMap::new // 구체적인 맵 구현체 지정
                ));
    }

    @Test
    @DisplayName("groupingBy 에제 코드")
    void groupingBy_예제_코드() {
        List<String> names = List.of("zayson", "maeng", "joon", "young", "yun", "chae", "young");

        // groupingBy (인수 1개)  길이로 맵 생성
        Map<Integer, List<String>> lengthMap = names.stream().collect(groupingBy(String::length));
        System.out.println("lengthMap = " + lengthMap);

        // groupingBy (인자 2개) : 첫번째 글자수가 몇개인지 확인
        Map<Character, Long> capitalCountMap = names.stream().collect(groupingBy(name -> name.charAt(0), counting()));
        System.out.println("capitalCountMap = " + capitalCountMap);

        // groupingBy (인자 3개) : 맵 팩토리를 받아 해당 타입으로 맵 생성되도록
        Map<Character, Long> capitalCountMap2 = names.stream().collect(groupingBy(name -> name.charAt(0), TreeMap::new, counting()));
        System.out.println("capitalCountMap2 = " + capitalCountMap2);
    }
}
