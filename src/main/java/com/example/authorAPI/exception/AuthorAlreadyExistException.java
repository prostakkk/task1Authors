package com.example.authorAPI.exception;

public class AuthorAlreadyExistException extends Exception {
    public AuthorAlreadyExistException(String message) {
        super(message);
    }
}
