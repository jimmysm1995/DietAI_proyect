package com.backend.DietAIbackend.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {
    private HttpStatus httpStatus;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

