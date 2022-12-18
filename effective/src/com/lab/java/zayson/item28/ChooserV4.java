package com.lab.java.zayson.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserV4<T> {
    // 배열 대신 리스트로 선언
    private final List<T> choiceList;

    public ChooserV4(Collection<T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    // 제너릭 타입으로 변경
    public T Choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
