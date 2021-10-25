package com.cyquen.exception.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = ArithmeticException.class)
    public String arithmeticExceptionHandler(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerExceptionHandler(Exception e) {
        return e.getMessage();
    }
}
