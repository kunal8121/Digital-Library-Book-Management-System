package com.Library.Digital.Library.Book.Management.System.ExceptionHangder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String , String>> handleValidationException(MethodArgumentNotValidException ex){

        Map<String ,String > errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField() ,error.getDefaultMessage()));
        return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
    }
}
