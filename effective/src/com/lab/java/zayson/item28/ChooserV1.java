package com.lab.java.zayson.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserV1 {
    private final Object[] choiceArray;

    public ChooserV1(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    // choose 메서드 호출할 때마다 Object 타입을 원하는 타입으로 형변환 필요
    // 다른 타입의 원소가 들어간 경우 런타임 시 에러 발생 가능한 문제
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
