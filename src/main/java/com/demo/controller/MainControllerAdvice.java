package com.demo.controller;

import com.demo.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleException(CustomException e) {
        String message = StringUtils.isEmpty(e.getMessage()) ? "Something went wrong" : e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}
