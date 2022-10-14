package com.example.ereading.service.exception;

import com.example.ereading.service.ServiceException;

public class PasswordErrorException extends ServiceException {
    public PasswordErrorException() {
        super();
    }

    public PasswordErrorException(String message) {
        super(message);
    }

}
