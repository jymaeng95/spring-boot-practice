package com.lab.java.zayson.item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    @Test
    @DisplayName("AutoClosable 테스트")
    void autoClosable() {
        try (Timer timer = new Timer()) {
            timer.countSecond();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}