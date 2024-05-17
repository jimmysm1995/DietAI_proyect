package com.backend.DietAIbackend.exception;

public class ServiceException extends RuntimeException {
    private int httpStatus;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}

