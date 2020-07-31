package com.survey.exception;

public class InfrastructureException extends Exception {

    private final IError error;

    public InfrastructureException(IError error) {
        this.error = error;
    }

    public InfrastructureException(String message, IError error) {
        super(message);
        this.error = error;
    }

    public InfrastructureException(String message, Throwable cause, IError error) {
        super(message, cause);
        this.error = error;
    }

    public InfrastructureException(Throwable cause, IError error) {
        super(cause);
        this.error = error;
    }

    public InfrastructureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IError error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }

    public IError getError() {
        return error;
    }

}
