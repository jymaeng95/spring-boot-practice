package com.lab.java.zayson.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class CustomUtil {
    public static List<Integer> intArrayAsList(int[] arr) {
        // null 체크
        Objects.requireNonNull(arr);

        // 필요한 부분만 확장해서 구현
        return new AbstractList<>() {
            // 추상 메서드 구현
            @Override
            public Integer get(int index) {
                System.out.println("추상 골격 구현 클래스 get 추상 메서드 구현");
                return arr[index];
            }

            @Override
            public int size() {
                System.out.println("사이즈 메서드 호출");
                return arr.length;
            }

            // 오버라이딩을 통한 확장 가능
            @Override
            public Integer set(int index, Integer element) {
                System.out.println("새롭게 확장한 내용이므로 출력됩니다!");

                int oldVal = arr[index];
                arr[index] = element;
                return oldVal;
            }
        };
    }
}
