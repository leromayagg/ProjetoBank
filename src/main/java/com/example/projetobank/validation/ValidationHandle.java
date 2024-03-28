package com.example.projetobank.validation;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationHandle {
    record ValidationError(String campo, String mensagem) {
        public ValidationError(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationError> handle(
            MethodArgumentNotValidException exception) {
        return exception
                .getFieldErrors()
                .stream()
                .map(ValidationError::new)
                .toList();
    }
}
