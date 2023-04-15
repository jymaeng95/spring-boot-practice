package com.lab.java.zayson.item87;

import java.io.Serializable;

public class Name implements Serializable {
    /**
     * 성 Not Null
     * @serial serial 태그는 private 필드여도 직렬화를 통해 공개 API가 되므로 직렬화 형태를 명시하기 위해 사용
     */
    private final String lastName;

    /**
     * 이름. Not Null
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름, Nullable
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // firstName, lastName의 경우 Not Null이기 때문에 불변식 보장을 위한 readObject 메서드가 필요

}
