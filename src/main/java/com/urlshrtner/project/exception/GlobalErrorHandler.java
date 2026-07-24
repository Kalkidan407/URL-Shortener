package com.urlshrtner.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;





@RestControllerAdvice
public class GlobalErrorHandler {

     

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorResponse> urlNotFoundException(
         UrlNotFoundException exception,
          HttpServletRequest request){

    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .message(exception.getMessage())
        .requestPath(request.getRequestURI())
        .build();

     return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(errorResponse);
          
    

        
    }
    
}
