package com.urlshrtner.project.exception;

public class UrlExistException extends RuntimeException {
    
    public UrlExistException(String message){
         super(message);
    }
}
