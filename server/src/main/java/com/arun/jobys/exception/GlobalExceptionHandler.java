package com.arun.jobys.exception;

import com.arun.jobys.dto.ErrorResponseDto;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        // Take the validation exception, get its validation result, get all the individual field errors
        // and store those errors in a list.
        List<FieldError> fieldsErrorList = exception.getBindingResult().getFieldErrors();

        fieldsErrorList.forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleException(HandlerMethodValidationException exception){
        Map<String, String> errors = new HashMap<>();

        List<ParameterValidationResult> results = exception.getParameterValidationResults();

        results.forEach(result-> {
            String paramName = result.getMethodParameter().getParameterName();

            String combinedMessage = result.getResolvableErrors()
                    .stream()
                    .map(MessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(","));

            errors.put(paramName, combinedMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }


}
