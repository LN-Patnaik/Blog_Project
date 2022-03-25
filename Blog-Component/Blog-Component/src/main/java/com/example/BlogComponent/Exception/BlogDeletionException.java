package com.example.BlogComponent.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BlogDeletionException extends Exception {

    public BlogDeletionException(String msg)
    {
        super(msg);
    }
}
