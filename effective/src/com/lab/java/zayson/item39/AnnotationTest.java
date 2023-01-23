package com.lab.java.zayson.item39;

public class AnnotationTest {
    // 성공
    @CustomTest
    @CustomTestInformation(writtenBy = "zayson", description = "마커 애너테이션 테스트")
    public static void v1(){
        System.out.println("Method 1");
    }

    // 예외가 발생해 실패
    @CustomTest
    public static void v2() {
        throw new RuntimeException("Failed Method 2");
    }

    // 정적 메서드가 아니라 실패
    @CustomTest
    public void v3() {
        System.out.println("error");
    }

    // 애노테이션이 안달려서 수행되지 않음
    public static void v4() {
        System.out.println("Not Tested Method 4");
    }
}