package com.example.authorAPI.exception;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
