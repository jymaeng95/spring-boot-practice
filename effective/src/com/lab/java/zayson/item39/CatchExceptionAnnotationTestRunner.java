package com.lab.java.zayson.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CatchExceptionAnnotationTestRunner {
    public static void main(String[] args) throws Exception {
        int testCount = 0;
        int passed = 0;

        CatchExceptionAnnotationTest targetClass = new CatchExceptionAnnotationTest();
        Class<?> testClass = Class.forName(targetClass.getClass().getName());

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CatchExceptionTest.class)) {
                testCount++;
                try {
                    method.invoke(null);
                    System.out.println("리플렉션을 통해 테스트 실행 -> 테스트 실패 :" + method);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    Class<? extends Throwable> exception = method.getAnnotation(CatchExceptionTest.class).exception();

                    // Custom Exception에 정의한 예외대로 나온 경우 제대로 동작한 테스트
                    if (exception.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.println("정의하지 않은 예외 발생 -> 테스트 실패 :" + method);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용된 애노테이션 메서드 : " + method);
                }
            }
        }

        System.out.println("성공 : " + passed + " 싪패 : " + (testCount - passed));
    }
}
