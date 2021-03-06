package com.summer.learning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundParameterException extends RuntimeException {
    
    public NotFoundParameterException(String message){
        super(message);
    }
}
