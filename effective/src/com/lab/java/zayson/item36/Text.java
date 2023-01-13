package com.lab.java.zayson.item36;

import java.util.Set;

public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Set의 어떤 자료구조도 넘길 수 있음
    public void applyStyles(Set<Style> styleSet) {
        styleSet.forEach(System.out::println);
    }
}
