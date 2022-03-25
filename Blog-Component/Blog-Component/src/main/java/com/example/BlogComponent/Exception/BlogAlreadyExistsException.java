package com.example.BlogComponent.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class BlogAlreadyExistsException extends RuntimeException {
    public  BlogAlreadyExistsException(String msg)
    {
        super(msg);
    }
}
