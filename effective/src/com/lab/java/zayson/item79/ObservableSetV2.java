package com.lab.java.zayson.item79;

import com.lab.java.zayson.item18.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSetV2<E> extends ForwardingSet<E> {
    public ObservableSetV2(Set<E> set) {
        super(set);
    }

    private final List<SetObserverV2<E>> observers = new CopyOnWriteArrayList<>();

    // Observer 구독
    public void addObserver(SetObserverV2<E> observer) {
        observers.add(observer);
    }

    // Observer 구독 해제
    public boolean removeObserver(SetObserverV2<E> observer) {
            return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserverV2<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) notifyElementAdded(element);

        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element);
        }

        return result;
    }
}
