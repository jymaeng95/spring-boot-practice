package com.lab.java.zayson.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionsTest {
    // 애너테이션 선언 시 줄괄호와 심표로 구분해 여러 개의 원소를 넣어주는 것이 가능
    Class<? extends Throwable>[] exceptions();
}
