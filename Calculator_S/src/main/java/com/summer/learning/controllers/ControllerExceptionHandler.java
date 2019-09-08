package com.summer.learning.controllers;

import com.summer.learning.exceptions.NotFoundException;
import com.summer.learning.exceptions.NotFoundParameterException;
import com.summer.learning.models.CustomErrorResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleWebExeption(NotFoundException e, WebRequest webRequest) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setTimestamp(LocalDateTime.now());
        customErrorResponse.setError(e.getMessage());
        customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundParameterException.class})
    public ResponseEntity<Object> handleWebExeption(NotFoundParameterException e, WebRequest webRequest) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setTimestamp(LocalDateTime.now());
        customErrorResponse.setError(e.getMessage());
        customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
    
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException e,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest webRequest){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", new Date());
        body.put("status: ", status.value());
        List<String> errors = e.getBindingResult()
                               .getFieldErrors()
                               .stream()
                               .map(x -> x.getDefaultMessage())
                               .collect(Collectors.toList());
        body.put("errors: ", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
}
