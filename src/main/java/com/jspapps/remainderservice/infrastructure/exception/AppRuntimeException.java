package com.jspapps.remainderservice.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/*
    Custom runtime exception class, use to catch exceptions
 */
@Getter
@Setter
public class AppRuntimeException extends RuntimeException {

    private String message;
    private String messageKey;
    private HttpStatus status;
    private Exception exception;

    public AppRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    public AppRuntimeException(String message, String messageKey) {
        super(message);
        this.message = message;
        this.messageKey = messageKey;
    }

    public AppRuntimeException(String message, String messageKey, Exception exception) {
        super(message);
        this.message = message;
        this.messageKey = messageKey;
        this.exception = exception;
    }

    public AppRuntimeException(String message, HttpStatus status, Exception exception) {
        super(message);
        this.message = message;
        this.status = status;
        this.exception = exception;
    }
}
