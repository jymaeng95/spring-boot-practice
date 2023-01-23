package com.lab.java.zayson.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTestRunner {
    public static void main(String[] args) throws Exception{
        int testCount = 0;
        int passed = 0;

        // AnnotationTest 클래스에 존재하는 테스트 애너테이션 실행
        AnnotationTest annotationTest = new AnnotationTest();
        Class<?> testClass = Class.forName(annotationTest.getClass().getName());

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CustomTest.class)) {
                testCount++;
                try {
                    method.invoke(null); // 리플렉션을 통해 CustomTest 애너테이션이 붙은 메서드 실행
                    passed++;

                }
                // 리플렉션을 통해 invoke 메서드가 실패하는 경우 -> InvocationTargetException을 발생
                catch (InvocationTargetException e) {
                    Throwable exception = e.getCause();
                    System.out.println(method + " failed " + exception);
                } catch (Exception e) {
                    System.out.println("잘못 사용된 @Test : " + method);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d", passed, (testCount - passed));
    }
}
