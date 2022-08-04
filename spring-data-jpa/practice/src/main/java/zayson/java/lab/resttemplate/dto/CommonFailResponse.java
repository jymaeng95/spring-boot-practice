package zayson.java.lab.resttemplate.dto;

import lombok.Getter;

@Getter
public class CommonFailResponse {
    private boolean status;
    private String message;

    public CommonFailResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
