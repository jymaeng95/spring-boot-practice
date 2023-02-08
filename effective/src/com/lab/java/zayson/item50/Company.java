package com.lab.java.zayson.item50;

public class Company {
    private final String name;

    // MutableAddress 필드를 final로 선언했지만, MutableAddress 클래스 내 필드가 가변이다.
    private final MutableAddress address;
    public Company(String name, MutableAddress address) {
        // 매개변수 체크
        if(address == null)
            throw new IllegalArgumentException("주소가 없는 경우 예외 처리");

        this.name = name;
        this.address = address;
    }

    // 방어적 복사 적용 필요 (편의상 가변 객체만 받도록 예시 코드 작성)
    public Company(MutableAddress address) {
        // 방어적 복사를 우선 수행한 뒤 매개변수 유효성 검사 진행
        name = "Nexon"; // 편의상 하드코딩
        this.address = new MutableAddress(address.getCity(), address.getZipcode()); // 방어적 복사

        // 매개변수 유효성 검사 (유효성 검사 -> 방어적 복사 하는 사이에 악의적 공격 가능)
        if(address == null)
            throw new IllegalArgumentException("주소가 없는 경우 예외 처리");
    }

    // getter

    public String getName() {
        return name;
    }

    public MutableAddress getAddress() {
        return new MutableAddress(address.getCity(), address.getZipcode());
    }

}
