package com.bjornspetprojects.currencyexchangeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions (Exception e, WebRequest request){
        ExceptionResponse excResponse = ExceptionResponse
                .builder()
                .timeStamp(LocalDateTime.now())
                .message(e.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(excResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExchangeValueNotExistingException.class)
    public final ResponseEntity<Object> handleUserNotFoundExceptions (ExchangeValueNotExistingException e, WebRequest request){
        ExceptionResponse excResponse = ExceptionResponse
                .builder()
                .timeStamp(LocalDateTime.now())
                .message(e.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(excResponse, HttpStatus.NOT_FOUND);
    }
}
