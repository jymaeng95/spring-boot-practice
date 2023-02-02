package com.lab.java.zayson.item47;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamTest {
    @Test
    @DisplayName("스트림은 반복을 지원하지 않음")
    void 스트림_반복_지원X() {
        Stream<Integer> stream = List.of(1, 2, 3, 4, 5, 6, 7, 8).stream();

        // 타입 캐스팅이 일어나지 않으면 스트림을 반복으로 사용 불가
        for (Integer x : (Iterable<Integer>) stream::iterator) {
            // some logic
        }

        for (Integer integer : iterableOf(stream)) {

        }


    }


    private static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    // 스트림 -> Iterable로 중개해주는 어댑터
    private static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }


}

