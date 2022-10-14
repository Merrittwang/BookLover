package com.example.ereading.service.exception;

import com.example.ereading.service.ServiceException;

public class UsernameErrorException extends ServiceException {
    public UsernameErrorException() {
        super();
    }

    public UsernameErrorException(String message) {
        super(message);
    }


}
