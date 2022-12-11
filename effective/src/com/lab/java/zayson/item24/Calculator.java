package com.lab.java.zayson.item24;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    private final int MOD = 100;
    private final String calcName = "Zayson's Calculator";

    // 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스로 사용
    public enum Operation {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }

    // private 정적 멤버 클래스 선언
    // 바깥 클래스에서만 접근 가능
    private static class PrivateCalculator {
        public int calculateMod(int x) {
            Calculator calculator = new Calculator();
            return x % calculator.MOD;  // private 멤버 접근 가능
        }
    }

    // public 정적 멤버 클래스 선언
    // 외부에서도 접근 가능
    public static class PublicCalculator {
        public int calculateMod(int x) {
            Calculator calculator = new Calculator();
            return x % calculator.MOD;
        }
    }

    public String getCalcName() {
        return calcName;
    }

    public int privateResult(int x) {
        PrivateCalculator privateCalculator = new PrivateCalculator();
        return privateCalculator.calculateMod(x);
    }

    public void printSort(List<Integer> list) {
        // 익명 클래스 사용
        Collections.sort(list, new Comparator<>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o1, o2);
                    }
                }
        );

        // 람다 사용
        Collections.sort(list, Comparator.comparingInt(o -> o));
        list.forEach(System.out::println);
    }
}
