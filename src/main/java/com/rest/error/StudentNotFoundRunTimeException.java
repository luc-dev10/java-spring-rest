package com.rest.error;

public class StudentNotFoundRunTimeException extends RuntimeException {

    public StudentNotFoundRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundRunTimeException(String message) {
        super(message);
    }

    public StudentNotFoundRunTimeException(Throwable cause) {
        super(cause);
    }

}
