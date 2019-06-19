package com.bindot.runap.web.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionRestHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<FieldError> handleAllExceptions(Exception ex, WebRequest request) {
        FieldError fieldError = new FieldError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(fieldError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BadRequestAlertException.class})
    public final ResponseEntity<FieldError> handlerBadRequestAlertException(BadRequestAlertException ex, WebRequest request) {
        FieldError fieldError = new FieldError(new Date(), ex.getMessage(), request.getDescription(false), ex.getEntityName(), ex.getErrorKey());
        return new ResponseEntity<>(fieldError, HttpStatus.NOT_FOUND);
    }
}
