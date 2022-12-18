package com.lab.java.zayson.item28;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayTest {
    @Test
    @DisplayName("공변")
    void 공변() {
        Object[] objects = new Long[1];
        objects[0] = "타입이 다르다.";  // 컴파일 에러는 발생 X, 런타임 에러 발생 (ArrayStoreException)
    }

    @Test
    @DisplayName("불공변")
    void 불공변() {
        // 컴파일 타임에 호환되지 않는 타입
//        List<Object> list = new ArrayList<Long>();
    }
}
