package com.lab.java.zayson.item76;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FailureAtomicExample {
    // 1. 불변 객체로 만들자
    private static ImmutablePerson failureAtomicV1(ImmutablePerson person) {
        int newAge = person.getAge() + 1;
        int newHeight = person.getHeight() + 10;

        if(newAge < 10) throw new RuntimeException(); //예외가 발생하더라도 기존 person객체의 상태가 변경되지 않음
        return new ImmutablePerson(newAge, person.getName(), newHeight);
    }

    // 2. 작업 수행에 앞서 매개변수의 유효성을 검사
    private static void failureAtomicV2(int[] array) {
        // 매개변수 유효성 검사
        if(array.length < 1) throw new IllegalArgumentException("배열 길이가 0입니다.");

        int first = array[0];
        System.out.println(first);
    }

    // 3. 객체의 임시 복사본에서 작업을 수행한 다음, 작업이 성공적으로 완료되면 원래 객체와 교체하는 것
    private static final List<String> failureAtomicV3(List<String> originalList) {
        List<String> tempList = new ArrayList<>(originalList);

        tempList.sort(String.CASE_INSENSITIVE_ORDER); // 정렬에서 문제가 발생하더라도 임시객체에서 문제 발생한 것이므로 원본 객체는 상태 유지

        originalList = tempList; // 정렬 성공하는 경우 원본 객체로 대치
        return originalList;
    }
}
