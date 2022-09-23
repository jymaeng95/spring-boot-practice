package zayson.java.lab.webclient.dto;


import lombok.Data;

import java.io.Serializable;
@Data
public class ApiResult<T> implements Serializable {
    private Boolean status;
    private T data;
    private String message;

    public ApiResult(){}
    public ApiResult(boolean status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
