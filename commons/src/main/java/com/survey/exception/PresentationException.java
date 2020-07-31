package com.survey.exception;

public class PresentationException extends Exception {

    private final IError error;

    public PresentationException(IError error) {
        this.error = error;
    }

    public PresentationException(String message, IError error) {
        super(message);
        this.error = error;
    }

    public PresentationException(String message, Throwable cause, IError error) {
        super(message, cause);
        this.error = error;
    }

    public PresentationException(Throwable cause, IError error) {
        super(cause);
        this.error = error;
    }

    public PresentationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IError error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }

    public IError getError() {
        return error;
    }

}
