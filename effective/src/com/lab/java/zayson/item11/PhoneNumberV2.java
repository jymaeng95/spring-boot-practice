package com.lab.java.zayson.item11;

import java.util.Objects;

public class PhoneNumberV2 {
    private final int areaCode, prefix, lineNum;

    public PhoneNumberV2(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // 1. 자기 자신 참조 확인
        if (!(o instanceof PhoneNumberV2)) // 2.입력이 올바른 타입인지 확인
            return false;
        PhoneNumberV2 that = (PhoneNumberV2) o;  // 3. 입력 타입 형 변환
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;  // 4. 핵심 필드 검사
    }

   /* @Override
    public int hashCode() {
        int result = Integer.hashCode(areaCode);  // 1. result 선언 후 c로 초기화 (객체의 첫번째 핵심 필드)
        result = 31 * result + Integer.hashCode(prefix);  // 2. 나머지 필드 f에 대해 해시코드 구하는 작업 수행
        result = 31 * result + Integer.hashCode(lineNum);

        return result;  // 3. result 리턴
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
