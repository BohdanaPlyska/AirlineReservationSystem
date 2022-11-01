package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomFoundException extends NotFoundException {

    public CustomFoundException(String message) {
        super(message);
    }

}
