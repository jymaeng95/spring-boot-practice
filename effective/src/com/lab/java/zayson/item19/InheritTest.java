package com.lab.java.zayson.item19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InheritTest {
    @Test
    @DisplayName("상위 클래스의 생성자가 하위 클래스의 생성자보다 먼저 호출된다.")
    void 상위_클래스의_생성자_호출() {
        Sub sub = new Sub();
        sub.overrideMe();
    }

    @Test
    @DisplayName("도우미 메서드 테스트")
    void 도우미_메서드_테스트() {
        Person zayson = new Person("zayson", 28);
        Person maeng = new Man("maeng", 28);

        // 상위 클래스
        zayson.walk();
        zayson.walk();
        zayson.stop();

        // 하위 클래스
        maeng.walk();
        maeng.walk();
        maeng.stop();
    }
}
