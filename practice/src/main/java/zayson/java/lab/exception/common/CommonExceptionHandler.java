package zayson.java.lab.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zayson.java.lab.exception.CustomBadRequestException;
import zayson.java.lab.exception.CustomNotFoundException;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ApiResult<String>> handleNotFoundException(CustomNotFoundException e) {
        System.out.println("e.getMessage() = " + e.getMessage());
        System.out.println("e.getCode() = " + e.getCode());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResult.fail(e.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<ApiResult<String>> handleCustomBadRequestException(CustomBadRequestException e) {
        return ResponseEntity.status(e.getCode()).body(ApiResult.fail(e.getMessage(), e.getCode()));
    }
}
