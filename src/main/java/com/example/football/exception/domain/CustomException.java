package com.example.football.exception.domain;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
