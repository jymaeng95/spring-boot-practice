package com.lab.java.zayson.item34;

import static com.lab.java.zayson.item34.PayrollDay.PayType.WEEKDAY;
import static com.lab.java.zayson.item34.PayrollDay.PayType.WEEKEND;

// 전략 열거 타입 패턴
public enum PayrollDay {
    // 상수 일부분이 동일한 동작을 공유 -> 새로운 열거타입(전략 열거 타입) 공유 - 내부에 동작 정의
    // private 하게 선언한 전략 열거 타입에서 알맞은 타입을 선택해서 기능 사용
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    // private 중첩 열거 타입 선언
    enum PayType {
        // 전략 열거 타입에서 동작을 정의하도록 추상메서드로 제공
        WEEKDAY {
            @Override
            int overtimePay(int minutes, int payRate) {
                return minutes <= MINUTES_PER_SHIFT ? 0 : (minutes - MINUTES_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int minutes, int payRate) {
                return minutes * payRate;
            }
        };

        // 열거타입에서 추상메서드 구현
        abstract int overtimePay(int minutes, int payRate);

        private static final int MINUTES_PER_SHIFT = 8 * 60;

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;

            return basePay + overtimePay(minutesWorked, payRate);
        }
    }
}
