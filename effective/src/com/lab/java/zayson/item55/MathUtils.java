package com.lab.java.zayson.item55;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class MathUtils {
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        // 컬렉션 원소 값이 빈 경우 값을 반환하는 것이 아닌 Optional을 반환
        if(c.isEmpty()) return Optional.empty();

        // 값이 있는 경우 로직 실행
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }

        // 반환 시 Optional.of 정적 팩토리 메서드로 생성해서 반환
        return Optional.of(result);
    }
}
