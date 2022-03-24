package com.dl.MoneyApi.services.exceptions;

public class FieldInvalidException extends RuntimeException {
    public FieldInvalidException(String message) {
        super(message);
    }
}
