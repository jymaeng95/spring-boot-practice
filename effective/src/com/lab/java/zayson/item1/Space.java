package com.lab.java.zayson.item1;

public class Space {
    private final String city;
    private final String street;
    private final int floor;

    private static final Space SPACE = new Space("city", "street", 5);


    /**
     * [단점]
     * 생성자를 private으로 만들고 정적 팩토리로 객체를 생성하는 경우 상속이 불가능하다.
     * 하위 타입 생성 불가능
     */
    public Space(String city, String street, int floor) {
        this.city = city;
        this.street = street;
        this.floor = floor;
    }

    // 1. 하나의 시그니처에 여러개 정적 팩토리 메서드 생성 가능
    public static Space newCafe(String city, String street, int floor) {
        return new Space(city, street, floor);
    }

    public static Space newCompany(String city, String street, int floor) {
        return new Space(city, street, floor);
    }

    // 2. 호출될 때 마다 인스턴스를 새로 생성하지 않아도 된다.
    public static Space valueOf() {
        return SPACE;
    }

    // 3. 반환 타입의 하위 타입 객체를 반환할 수 있다.
    // 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    public static Space getSpaceByType(String type) {
        if(type.equals("company")) return Company.INSTANCE;
        if(type.equals("cafe")) return Cafe.INSTANCE;

        throw new IllegalStateException("존재하지 않는 공간입니다.");
    }
}
