package zayson.java.lab.exception;

import org.springframework.http.HttpStatus;
import zayson.java.lab.exception.common.CommonException;
import zayson.java.lab.exception.common.ErrorCode;

public class CustomBadRequestException extends CommonException {

    public CustomBadRequestException(String message) {
        super(message);

    }

    public CustomBadRequestException(ErrorCode errorCode) {
        super(errorCode);

    }

    public CustomBadRequestException(String message, HttpStatus code) {
        super(message, code);

    }
}
