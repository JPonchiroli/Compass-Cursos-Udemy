package com.pbcompass.park_api.exception;

public class PasswordMismatchException extends PasswordInvalidException{
    public PasswordMismatchException(String message) {
        super(message);
    }
}
