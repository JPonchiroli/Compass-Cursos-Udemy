package com.pbcompass.park_api.exception;

public class PasswordConfirmationMismatchException extends PasswordInvalidException{
    public PasswordConfirmationMismatchException(String message) {
        super(message);
    }
}
