package com.lab.java.zayson.item45;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.*;
import static java.util.stream.Collectors.*;

public class StreamTest {
    @Test
    @DisplayName("반복문을 이용한 아나그램 그룹 출력")
    void 반복문_애너그램() {
        List<String> dictionary = Arrays.asList("zayson", "sonzay", "maeng", "zaynos", "sonayz", "agmen");
        int minGroupSize = 1;

        Map<String, Set<String>> groups = new HashMap<>();
        for (String word : dictionary) {
            // 단어를 정렬한 키가 존재하면 넣고, 아닌 경우 새로운 트리셋을 키로 만듬
            groups.computeIfAbsent(Anagrams.alphabetize(word), (unused) -> new TreeSet<>()).add(word);
        }

        for (Map.Entry<String, Set<String>> entry : groups.entrySet()) {
            if (entry.getValue().size() > minGroupSize) {
                System.out.println("key : " + entry.getKey() + " values : " + entry.getValue());
            }
        }
    }

    @Test
    @DisplayName("스트림 애너그램 그룹 출력")
    void 스트림_애너그램() {
        List<String> dictionary = Arrays.asList("zayson", "sonzay", "maeng", "zaynos", "sonayz", "agmen");
        int minGroupSize = 1;

        dictionary.stream()
                .collect(groupingBy(Anagrams::alphabetize)) // 애너그램 기준으로 그룹핑
                .values().stream()  // List<Set> 스트림을 재생성
                .filter(group -> group.size() > minGroupSize)// 최소 그룹 개수 필터링
                .forEach(System.out::println);  // 출력 (종단연산)
    }

    @Test
    @DisplayName("메르센 소수")
    void 메르센_소수() {
        Stream<BigInteger> primes = Stream.iterate(TWO, BigInteger::nextProbablePrime);

        primes.map(p -> TWO.pow(p.intValueExact()).subtract(ONE))   // 제곱
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + " : " + mp)); // 종단 연산에서 지수로 들어가는것을 보이기 위해 비트의 길이로 거꾸로 계산
    }
}
