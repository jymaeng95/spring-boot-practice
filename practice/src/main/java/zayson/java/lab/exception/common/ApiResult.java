package zayson.java.lab.exception.common;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
public class ApiResult<T> {
    private T data;
    private String error;
    private HttpStatus code;

    public ApiResult(T data, HttpStatus code) {
        this.data = data;
        this.code = code;
    }

    public ApiResult(String error, HttpStatus code) {
        this.error = error;
        this.code = code;
    }

    public static <T> ApiResult<T> fail(String error, HttpStatus code) {
        return new ApiResult<>(error, code);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(data, HttpStatus.OK);
    }
}
