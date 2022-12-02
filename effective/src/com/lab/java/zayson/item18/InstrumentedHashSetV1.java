package com.lab.java.zayson.item18;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSetV1<E> extends HashSet<E> {
    private int addCount = 0;
    public InstrumentedHashSetV1() {}

    public InstrumentedHashSetV1(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    // addCount를 증가시키지만 super.addAll에서 재정의한 add를 호출하기 때문에 중복으로 더해지는 문제 발생
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddCount() {
        return addCount;
    }
}
