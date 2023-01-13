package com.lab.java.zayson.item36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

public class EnumSetTest {
    @Test
    @DisplayName("EnumSet 이전과 이후를 확인")
    void EnumSet_이전_이후() {
        // 비트를 이용한 정수 상수
        PastText pastText = new PastText();
        pastText.applyStyles(PastText.STYLE_ITALIC | PastText.STYLE_STRIKETHROUGH); // 정수 상수들의 OR 연산을 통해 전달

        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.ITALIC, Text.Style.STRIKETHROUGH)); // EnumSet을 통한 열거 상수 집합 전달
    }
}
