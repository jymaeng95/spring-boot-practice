package com.lab.java.zayson.item57;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Element;
import java.util.Iterator;
import java.util.List;

public class LoopTest {
    public static void main(String[] args) {
        // while문을 사용하면서 발생할 수 있는 오류
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(6, 7, 8, 9, 10);

        Iterator<Integer> i = list1.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        Iterator<Integer> i2 = list2.iterator();
        while (i2.hasNext()) {
            System.out.println(i.next()); // 반복 변수의 범위가 끝나지 않아서 발생할 수 있는 오류
        }

        // doSomething을 반복문 범위에서만 사용하는 경우 반복문과 라이프사이클을 동일하게 유지
        for (int index = 0, size = doSomething(); index < size; index++) {
            System.out.println(index);
        }
    }

    private static int doSomething() {
        return 10;
    }
}
