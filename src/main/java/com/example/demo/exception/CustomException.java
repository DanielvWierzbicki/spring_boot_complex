package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private HttpStatus status;
    private String customMessage;

    public CustomException(HttpStatus httpStatus, String customMessage) {
        super(customMessage);
        this.status = httpStatus;
        this.customMessage = customMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
