package zayson.java.lab.exception.common;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    BAD_REQUEST("bad request", HttpStatus.BAD_REQUEST),
    NOT_FOUND("NOT FOUND", HttpStatus.NOT_FOUND),
    ;

    private  String message;
    private  HttpStatus code;

    ErrorCode(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getCode() {
        return code;
    }
}
