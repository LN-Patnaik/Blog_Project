package com.example.BlogComponent.Exception;

public class AuthorAlreadyExistsException extends RuntimeException {
    public AuthorAlreadyExistsException(String msg) {
        super(msg);
    }
}
