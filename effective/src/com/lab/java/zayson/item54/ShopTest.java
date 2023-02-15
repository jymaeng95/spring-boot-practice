package com.lab.java.zayson.item54;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ShopTest {
    @Test
    @DisplayName("빈 컬렉션에 null을 반환하는 경우")
    void 빈_컬렉션에_null을_반환하는_경우() {
        Shop shop = new Shop();
        List<Cheese> cheeses = shop.getCheeses();

        // Empty Collection이 아닌 null이 넘어오기 때문에 Null Check가 필수적이.
        if (cheeses != null && cheeses.contains(CheeseType.GORGONZOLA)) {
            System.out.println("null을 체크해야한다");
        }
    }


}
