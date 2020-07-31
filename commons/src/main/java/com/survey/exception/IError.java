package com.survey.exception;

import java.io.Serializable;

public interface IError extends Serializable {

    public Integer getStatus();

    public Long getCode();

    public String getMessage();

}
