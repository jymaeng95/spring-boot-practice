package com.lab.java.zayson.item24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NestedClassTest {
    @Test
    @DisplayName("정적 멤버 클래스 테스트")
    void 정적_멤버_클래스_테스트() {
        Calculator calculator = new Calculator();
        String calcName = calculator.getCalcName();

        // public 정적 멤버는 외부에서도 접근 가능
        Calculator.PublicCalculator publicCalculator = new Calculator.PublicCalculator();
        int result = publicCalculator.calculateMod(28);

        System.out.println("result = " + result);

        // private 정적 멤버는 외부에서 접근 불가
//        Calculator.PrivateCalculator privateCalculator = new Calculator().PrivateCalculator();

    }

    @Test
    @DisplayName("비정적 멤버 클래스 테스트")
    void 비정적_멤버_클래스_테스트() {
        OuterClass outerClass = new OuterClass();

        // 1. 비정적 멤버 클래스 자동 호출
        OuterClass.InnerClass innerClass = outerClass.createInnerClass();

        // 2. 수동 호출
        OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

        // 바깥 클래스가 인스턴스화 되지 않은 경우 생성 불가
//        new OuterClass.InnerClass();

        // 바깥 클래스 필드 접근해서 호출
        innerClass.print();

        // 바깥 클래스 메서드 호출
        innerClass1.printOuterMethod();
    }
}