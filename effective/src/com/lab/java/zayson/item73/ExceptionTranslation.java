package com.lab.java.zayson.item73;

public class ExceptionTranslation {
    public static void main(String[] args) {
        try {
            actionLowerException();
        } catch (LowerLevelException e) {
            // 저수준 예외를 잡아 현재 추상화 기준에 맞게 번역해 바꿔 던짐 : 얘와 번역
            throw new HigherLevelException(e.getMessage());
        }
    }

    private static void actionLowerException() {
        System.out.println("Do Something");

        throw new LowerLevelException("Lower Lever Exception thrown by actionLowerException");
    }
}
