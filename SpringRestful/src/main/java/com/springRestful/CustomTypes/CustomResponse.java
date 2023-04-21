package com.springRestful.CustomTypes;

import lombok.Data;

@Data
public class CustomResponse {
    private boolean success;
    private String message;

    public CustomResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
