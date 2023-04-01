package com.lab.java.zayson.item79;

import com.lab.java.zayson.item18.ForwardingSet;
import net.bytebuddy.implementation.bytecode.Addition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    // Observer 구독
    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    // Observer 구독 해제
    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    /*private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);  // 구독중인 옵저버에 전달
            }
        }
    }*/

    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null; // 복사 객체 생성
        synchronized (observers) {
            snapshot = new ArrayList<>(observers); // 객체 복사
        }
        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added) notifyElementAdded(element);

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
