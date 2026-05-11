package com.example23.demo.exception;

public class PatienNotFoundException extends RuntimeException {
    public PatienNotFoundException(String message) {
        super(message);
    }
}
