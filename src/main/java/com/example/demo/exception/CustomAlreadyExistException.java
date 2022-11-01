package com.example.demo.exception;

import org.springframework.security.acls.model.AlreadyExistsException;

public class CustomAlreadyExistException extends AlreadyExistsException {

    public CustomAlreadyExistException(String message) {
        super(message);
    }

}
