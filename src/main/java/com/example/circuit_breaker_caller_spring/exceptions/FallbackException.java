package com.example.circuit_breaker_caller_spring.exceptions;

public class FallbackException extends RuntimeException {

    private String message;

    public FallbackException(String message, Throwable cause) {
        super(message, cause);
    }
}
