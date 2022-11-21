package com.lab.java.zayson.item10;

import java.util.Objects;

public class MyString {
    private final String s;

    public MyString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        // Object가 MyString 타입의 경우
        if(o instanceof MyString)
            return s.equalsIgnoreCase(((MyString) o).s);

        // Object가 String 타입인 경우 (String 클래스는 MyString 타입을 모르므로 대칭성 규약을 어김
        if(o instanceof String)
            return s.equalsIgnoreCase((String) o);

        return false;
    }
}
