package com.lab.java.zayson.item27;

import com.lab.java.zayson.item19.Person;
import net.bytebuddy.matcher.FilterableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WarningTest {
    @Test
    @DisplayName("제네릭 다이아몬드 연산자 확인")
    void 다이아몬드_연산자() {
        @SuppressWarnings("unchecked")
        List<Person> list = new ArrayList();
    }
}
