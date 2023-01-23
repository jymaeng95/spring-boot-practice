package com.lab.java.zayson.item39;

public class CatchExceptionAnnotationTest {
    // 올바른 예외가 발생해 테스트 성공
    @CatchExceptionTest(exception = IndexOutOfBoundsException.class)
    public static void IndexOutOfRangeExceptionHandler() {
        int[] array = new int[5];
        System.out.println("Maybe throw Exception array[5] = " + array[5]);
    }

    // 다른 예외가 발생해서 테스트 실패
    @CatchExceptionTest(exception = IndexOutOfBoundsException.class)
    public static void ArithmeticExceptionHandler() {
        int number = 5;
        System.out.println("Maybe throw Exception in Operation" + number / 0);  // ArithmeticException
    }

    @CatchExceptionTest(exception = IndexOutOfBoundsException.class)
    public static void passTest() {
        System.out.println("정상적으로 동작했지만, 애노테이션을 통해 예외를 지정했기 때문에 테스트 실패");

    }
}

