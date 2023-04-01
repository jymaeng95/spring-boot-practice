package com.lab.java.zayson.item79;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSetExample {
    public static void main(String[] args) {
//        successMethod();

//        failMethod();

        failMethodWithExecutorService();
    }

    private static void failMethod() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                // 원소가 23인 경우 현재 옵저버를 구독 해제
                if (element == 23) {
                    set.removeObserver(this);
                }
            }
        });

        // ObservableSet의 notifyElementAdded 수행과 removeObserver 수행이 겹쳐 예외 발생
        for (int index = 0; index < 100; index++) {
            set.add(index);
        }
    }

    private static void successMethod() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(((set1, element) -> System.out.println(element)));

        for (int index = 0; index < 100; index++) {
            set.add(index);
        }
    }

    private static void failMethodWithExecutorService() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                // 원소가 23인 경우 현재 옵저버를 구독 해제
                if (element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();

                    try {
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException e) {
                        throw new AssertionError(e);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        // ObservableSet의 notifyElementAdded 수행과 removeObserver 수행이 겹쳐 예외 발생
        for (int index = 0; index < 100; index++) {
            set.add(index);
        }
    }
}
