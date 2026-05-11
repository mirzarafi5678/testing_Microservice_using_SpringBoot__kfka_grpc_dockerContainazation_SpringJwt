package com.example23.demo.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionClass {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionClass.class);

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
   @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        log.warn("email alreadsy exists {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message ", "email already exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatienNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatienNotFoundException(PatienNotFoundException ex) {
        log.warn("patient not found {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message ", "patient not found");

    return ResponseEntity.badRequest().body(errors);
    }
}


