package com.lab.java.zayson.item39;

public class ExceptionsAnnotationTest {
    @ExceptionsTest(exceptions = {
            IllegalArgumentException.class,
            NullPointerException.class
    })
    public static void exceptionTest() {
        throw new NullPointerException("NPE!!!!");
    }
}
