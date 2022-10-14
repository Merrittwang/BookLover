package com.example.ereading.service.exception;

import com.example.ereading.service.ServiceException;

public class DuplicateUsernameException extends ServiceException {
    public DuplicateUsernameException() {
        super();
    }

    public DuplicateUsernameException(String message) {
        super(message);
    }

}
