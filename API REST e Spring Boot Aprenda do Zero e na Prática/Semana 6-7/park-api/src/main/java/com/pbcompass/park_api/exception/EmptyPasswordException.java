package com.pbcompass.park_api.exception;

public class EmptyPasswordException extends PasswordInvalidException{
    public EmptyPasswordException(String message) {
        super(message);
    }
}
