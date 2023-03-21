package com.lab.java.zayson.item73;

public class HigherLevelException extends RuntimeException {
    public HigherLevelException(String message) {
        super(message);
    }

    public HigherLevelException(Throwable cause) {
        super(cause);
    }
}
