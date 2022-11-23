package com.lab.java.zayson.item11;

public class PhoneNumberV1 {
    private final int areaCode, prefix, lineNum;

    public PhoneNumberV1(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // 1. 자기 자신 참조 확인
        if (!(o instanceof PhoneNumberV1)) // 2.입력이 올바른 타입인지 확인
            return false;
        PhoneNumberV1 that = (PhoneNumberV1) o;  // 3. 입력 타입 형 변환
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;  // 4. 핵심 필드 검사
    }
}
