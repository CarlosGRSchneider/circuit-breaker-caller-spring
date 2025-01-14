package com.example.circuit_breaker_caller_spring.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(Exception exception, HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), request.getRequestURI());

        System.out.println("Erro = " + errorResponse);

        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
