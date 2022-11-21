package com.lab.java.zayson.item10;

import java.util.Objects;

public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // 1. 자기 자신 참조 확인
        if(!(o instanceof PhoneNumber)) // 2.입력이 올바른 타입인지 확인
            return false;
        PhoneNumber that = (PhoneNumber) o;  // 3. 입력 타입 형 변환
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;  // 4. 핵심 필드 검사
    }
}
