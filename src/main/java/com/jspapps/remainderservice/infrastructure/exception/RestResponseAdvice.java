package com.jspapps.remainderservice.infrastructure.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseAdvice {

    @ExceptionHandler(AppRuntimeException.class)
    public final ResponseEntity<Object> runtimeExceptionHandler(AppRuntimeException runtimeException) {
        var exceptionSchema = new ExceptionSchema(runtimeException.getMessage(), runtimeException.getMessageKey());
        exceptionSchema.setStackTrace(ExceptionUtils.getRootCauseMessage(runtimeException.getException()));
        return new ResponseEntity<>(exceptionSchema, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
