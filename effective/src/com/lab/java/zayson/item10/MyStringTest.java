package com.lab.java.zayson.item10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyStringTest {
    @Test
    @DisplayName("MyString, String 타입 간 equals 대칭성 테스트")
    void symmetry_equals() {
        MyString str1 = new MyString("zayson");
        MyString str2 = new MyString("zayson");

        String str3 = "Zayson";

        assertThat(str1.equals(str2)).isTrue();
        assertThat(str2.equals(str1)).isTrue();

        assertThat(str1.equals(str3)).isTrue();
        assertThat(str3.equals(str1)).isFalse();
    }

    @Test
    @DisplayName("equals 위배한 객체 컬렉션 추가")
    void add_collection() {
        List<MyString> myStringList = new ArrayList<>();
        myStringList.add(new MyString("zayson"));

        assertThat(myStringList.contains("zayson")).isFalse();
        assertThat(myStringList.contains(new MyString("zayson"))).isTrue();
    }

    @Test
    @DisplayName("MyStringV2 대칭성 테스트")
    void V2() {
        MyStringV2 str1 = new MyStringV2("zayson");
        MyStringV2 str2 = new MyStringV2("zayson");

        String str3 = "Zayson";

        assertThat(str1.equals(str2)).isTrue();
        assertThat(str2.equals(str1)).isTrue();

        // MyString 타입간의 비교만 허용
        assertThat(str1.equals(str3)).isFalse();
        assertThat(str3.equals(str1)).isFalse();
    }
}