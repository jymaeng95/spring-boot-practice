package com.lab.java.zayson.item79;

@FunctionalInterface  public interface SetObserver<E> {
    // ObservableSet에 원소가 더해지면 호출됨
    void added(ObservableSet<E> set, E element);
}
