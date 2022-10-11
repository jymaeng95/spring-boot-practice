package zayson.java.lab.exception.common;

import org.springframework.http.HttpStatus;

public abstract class CommonException extends RuntimeException {
    private String message;
    private HttpStatus code;
    public CommonException(String message) {
        super(message);
        this.message = message;
    }

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    public CommonException(String message, HttpStatus code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getCode() {
        return code;
    }
}
