package com.lab.java.zayson.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserV2<T> {
    private final T[] choiceArray;

    public ChooserV2(Collection<T> choices) {
        this.choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
