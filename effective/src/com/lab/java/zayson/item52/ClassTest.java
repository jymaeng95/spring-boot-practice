package com.lab.java.zayson.item52;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

public class ClassTest {
    @Test
    @DisplayName("메서드 오버로딩은 메서드 호출 결정을 컴파일 타임에 결정")
    void 메서드_오버로딩의_호출_시점은_컴파일_타임() {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<Integer>(),
                new HashMap<String, String>().values()
        };

        // 차례대로 집합 -> 리스트 -> 그 외 문자열을 출력할 것이라 기대
        for (Collection<?> collection : collections) {
            System.out.println("ClassOverloading.classify(collection); = " + ClassOverloading.classify(collection));
        }
    }

    @Test
    @DisplayName("메서드 오버라이딩은 메서드 호출 결정을 런타임에 결정")
    void 메서드_오버라이딩의_호출_시점은_런타임() {
        NexonGames nexonGames = new NexonGames();
        NexonGames mapleStory = new MapleStory();
        NexonGames fifaOnline4 = new FifaOnline4();

        // 상위 타입으로 전달 받더라도 재정의한 메서드를 런타임시에 판단하므로 예상한 결과가 나옴
        assertThat(nexonGames.title()).isEqualTo("넥슨 게임");
        assertThat(mapleStory.title()).isEqualTo("메이플스토리");
        assertThat(fifaOnline4.title()).isEqualTo("피파온라인 4");
    }

    @Test
    @DisplayName("다중정의 해소 관련 예제")
    void 다중정의_해소_관련_예제() {
        // 1. Thread 생성자 호출
        new Thread(System.out::println).start();

        // 2. ExecutorService의 submit 메서드 호출
        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.submit(System.out::println);  // println, submit의 다중정의로 인해 어떤 메서드를 사용할지 모호해 컴파일 에러
        exec.submit(()-> System.out.println("test")); // Runnable
        exec.submit(() -> "Test"); // Callable
    }
}
