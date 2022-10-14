package com.example.ereading.service.exception;

import com.example.ereading.service.ServiceException;

public class InsertException extends ServiceException {
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }


}