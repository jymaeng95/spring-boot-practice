package com.lab.java.zayson.item63;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class StringConcatTimeTest {
    @Test
    @DisplayName("Stirng 연산과 StringBuilder 연산 시간 비교")
    void compare_String_StringBuilder() {
        List<String> nameList = createList();

        // String Concat 연산 측정
        long stringStartTime = System.currentTimeMillis();
        String concatString = "";
        for (String name : nameList) {
            concatString += name;
        }
        long stringEndTime = System.currentTimeMillis();

        // StringBuilder 실행 시간 측정
        long stringBuilderStartTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (String name : nameList) {
            builder.append(name);
        }
        long stringBuilderEndTime = System.currentTimeMillis();

        System.out.println("stringTime = " + (stringEndTime - stringStartTime));
        System.out.println("StringBuilder Time  = " + (stringBuilderEndTime - stringBuilderStartTime));

        // StringBuilder가 속도가 빠를 것
        assertThat(stringEndTime - stringStartTime).isGreaterThan(stringBuilderEndTime - stringBuilderStartTime);
    }

    private static List<String> createList() {
        List<String> nameList = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            if (index % 2 == 0) nameList.add("zayson");
            else nameList.add("maeng");
        }

        return nameList;
    }

}
