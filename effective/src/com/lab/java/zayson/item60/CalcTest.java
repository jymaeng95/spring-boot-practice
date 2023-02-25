package com.lab.java.zayson.item60;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalcTest {
    @Test
    @DisplayName("float, double을 사용한 계싼은 근사치라 정확한 결과가 나오지 않는다.")
    void double_float은_근사치() {
        double funds = 1.00;
        int itemBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemBought++;
        }

        System.out.println("funds = " + funds);
        Assertions.assertThat(funds).isNotEqualTo(0.00);
    }

    @Test
    @DisplayName("BigDecimal, int, long을 이용한 계산은 정확한 결과가 나온다")
    void bigDecimal은_정확한_계산() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemBought++;
        }

        Assertions.assertThat(funds.doubleValue()).isEqualTo(0.00);
    }
}
