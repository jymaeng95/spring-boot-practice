package com.lab.java.zayson.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 매개변수를 하나 갖는 애너테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CatchExceptionTest {
    // Throwable을 상속하는 Exeption 클래스를 파라미터로 넘겨준다.
    Class<? extends Throwable> exception();
}
