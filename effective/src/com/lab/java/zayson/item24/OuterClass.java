package com.lab.java.zayson.item24;

import java.util.AbstractSet;

public class OuterClass {
     private String name = "Outer Class";

     public class InnerClass {
          // 바깥 인스턴스 멤버 접근
          public void print() {
               System.out.println(name);
          }

          // 바깥 메서드 호출
          public void printOuterMethod() {
               OuterClass.this.callMethodByInnerClass();
          }
     }

     public InnerClass createInnerClass() {
          // 1. 바깥 클래스의 인스턴스 메서드에서 비정적 멤버 클래스의 생성자를 호출
          return new InnerClass();
     }

     public void callMethodByInnerClass() {
          System.out.println("비정적 멤버 클래스에서 호출된 메서드 입니다.");
     }
}
