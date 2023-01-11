package com.lab.java.zayson.item34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnumTest {
    @Test
    @DisplayName("Enum 타입의 특징")
    void 열거_타입의_특징() {
        // 1. 컴파일 타임의 타입 안전성 제공
//        if(isApple(Banana.MONKEY_BANANA)) System.out.println("몽키바나나?"); // 컴파일 에러

        // 2. 각자의 네임스페이스를 통한 동일 상수의 공존화
        assertTrue(Apple.FUJI instanceof Apple);
        assertTrue(com.lab.java.zayson.item34.Apple.FUJI instanceof com.lab.java.zayson.item34.Apple);

        // 4. toString 메서드 자동 지원
        System.out.println("Apple.FUJI.toString() = " + Apple.FUJI.toString());

        // 5. Enum 클래스 내부에 필드 및 메서드 추가 가능
        assertTrue(Apple.checkLength(Apple.FUJI));
    }

    private static boolean isApple(Apple apple) {
        if (apple == null)
            throw new AssertionError("파라미터가 null값일 수 없습니다.");
        return apple instanceof Apple;
    }

    // 3. enum 클래스 원소의 순서가 변경되어도 다시 컴파일 할 필요 없음
    enum Apple {
        FUJI, PIPPIN, MONKEY_APPLE;

        // 5. enum 클래스 내부에 필드 및 메서드 추가 가능
        private static final int MAX_LENGTH = 10;
        public static boolean checkLength(Apple type) {
            return type.toString().length() <= MAX_LENGTH;
        }
    }
}
