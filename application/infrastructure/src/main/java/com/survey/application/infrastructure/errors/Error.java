package com.survey.application.infrastructure.errors;


import com.survey.exception.IError;

public enum Error implements IError {

    RESOURCE_NOT_FOUND(500, 0L, "Element not found");

    private Integer status;
    private Long code;
    private String message;

    Error(Integer status, Long code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
