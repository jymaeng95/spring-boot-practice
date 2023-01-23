package com.lab.java.zayson.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface CustomTestInformation {

    // 일반 적인 애노테이션은 밸류값 설정 가능
    String writtenBy();

    String description();
}
