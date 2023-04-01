package com.lab.java.zayson.item79;

@FunctionalInterface  public interface SetObserverV2<E> {
    // ObservableSet에 원소가 더해지면 호출됨
    void added(ObservableSetV2<E> set, E element);
}
