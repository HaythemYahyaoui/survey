package com.survey.application.presentation.errors;

import com.survey.exception.IError;

public enum Error implements IError {

    DEFAULT(500, 0L, "Internal server error"),
    BAD_REQUEST(400, 2L, "Bad request");

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
