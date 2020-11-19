package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationAlreadyExists.class)
    String handleApplicationException(ApplicationAlreadyExists applicationAlreadyExists)
    {
        return applicationAlreadyExists.getMessage() ;
        }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationIdNotFound.class)
    String handleApplicationException(ApplicationIdNotFound applicationIdNotFound)
    {
        return applicationIdNotFound.getMessage() ;
        }
    
    
    
}