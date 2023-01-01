package com.lab.java.zayson.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    // 모든 키의 타입이 제각각 = 유연하게 여러 타입 원소를 담는 것 가능
    private Map<Class<?>, Object> favorites = new HashMap<>();
    public <T> void putFavorite(Class<T> type, T instance) {
        // 동적 형변환을 이용해 로 타입이 넘어온 경우 타입 안전성 보장
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
