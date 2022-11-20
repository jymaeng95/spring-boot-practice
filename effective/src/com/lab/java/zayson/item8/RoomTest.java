package com.lab.java.zayson.item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoomTest {
    @Test
    @DisplayName("try-with-resources 사용")
    void 자동_종료되는_경우() {
        try (Room room = new Room(10)) {
            System.out.println("쓰레기가 많으니 치우렴...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("자동 종료되지 않는 경우")
    void 자동_종료되지_않는_경우() {
        Room room = new Room(10);
        System.out.println("쓰레기가 많으니 치우렴...");

        // 방 청소가 호출되지 않은 이유 = cleaner가 수행되는 시점 판단 여부 모름
    }
}
