package com.lab.java.zayson.item24;

public class NestedClass {
    private String nestedName = "바깥 클래스";

    // 비정적 문맥
    public void print() {
        class LocalClass {
            private String localName = "지역 클래스";
            // 정적 멤버를 가질 수 없음
//            private static String staticName = "지역 클래스";

            public void printLocal() {
                System.out.println("지역 클래스 내 메서드 호출");
                System.out.println("nesteName = " + nestedName);
                System.out.println("localName = " + localName);
            }
        }
    }

    // 정적 문맥
    public static void printStaticMethod() {
        class LocalClass {
            private String localName = "지역 클래스";
            // 정적 멤버를 가질 수 없음
//            private static String staticName = "지역 클래스";

            public void printLocal() {
                // 정적 문맥에서는 외부 인스턴스 참조 불가
//                System.out.println("nesteName = " + nestedName);
                System.out.println("localName = " + localName);
            }
        }
    }
}
