package com.pbcompass.park_api.exception;

import lombok.Getter;

@Getter
public class CodeUniqueViolationException extends RuntimeException{

    private String resource;
    private String code;


    public CodeUniqueViolationException(String msg){
        super(msg);
    }

    public CodeUniqueViolationException(String resource, String code){
        this.resource = resource;
        this.code = code;
    }
}
