package zayson.java.lab.exception;

import org.springframework.http.HttpStatus;
import zayson.java.lab.exception.common.CommonException;
import zayson.java.lab.exception.common.ErrorCode;

public class CustomNotFoundException extends CommonException {

    public CustomNotFoundException(String message) {
        super(message);

    }

    public CustomNotFoundException(ErrorCode errorCode) {
        super(errorCode);

    }

    public CustomNotFoundException(String message, HttpStatus code) {
        super(message, code);

    }
}
