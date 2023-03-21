package com.lab.java.zayson.item73;

public class ExceptionChaining {
    public static void main(String[] args) {
        try {
            actionLowerException();
        } catch (LowerLevelException e) {
            // 저수준 예외 원인이 디버깅에 유용한 경우 원인을 담아 보냄 : 예외 연쇄
            throw new HigherLevelException(e.getCause());
        }
    }

    private static void actionLowerException() {
        System.out.println("Do Something");

        throw new LowerLevelException("Lower Lever Exception thrown by actionLowerException");
    }
}
