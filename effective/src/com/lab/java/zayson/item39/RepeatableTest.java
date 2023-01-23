package com.lab.java.zayson.item39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(value = RepeatableTestContainer.class)
public @interface RepeatableTest {
    Class<? extends Throwable> value();
}
