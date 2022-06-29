package com.spring.practice.resttemplate.web.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CommonSuccessResponse implements Serializable {
    private Boolean status;
    private Object data;
    private String message;

    public CommonSuccessResponse(boolean status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
