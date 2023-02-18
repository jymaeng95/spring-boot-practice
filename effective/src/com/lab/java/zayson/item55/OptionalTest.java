package com.lab.java.zayson.item55;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {
    @Test
    @DisplayName("옵셔널 기본 메서드 예제")
    void 옵셔널_기본_메서드() {
        List<String> nameList = Collections.emptyList();
        Optional<String> max = MathUtils.max(nameList);

        // Optional.Emtpy가 들어오는 경우 기본값으로 저장 (orElse)
        String maxName = max.orElse("단어 없음");
        assertThat(maxName).isEqualTo("단어 없음");

        // 예외 팩터리 넘기기 (orElseThrow)
        assertThrows(IllegalArgumentException.class, () -> max.orElseThrow(IllegalArgumentException::new));

        // 값이 없는 경우 get을 하는 경우 (NoSuchElementException 발생)
        assertThrows(NoSuchElementException.class, max::get);

        // 기본값을 값이 처음 필요한 경우에 설정하는 것
        String result = max.orElseGet(() -> "Supplier Method Length");
    }
}
