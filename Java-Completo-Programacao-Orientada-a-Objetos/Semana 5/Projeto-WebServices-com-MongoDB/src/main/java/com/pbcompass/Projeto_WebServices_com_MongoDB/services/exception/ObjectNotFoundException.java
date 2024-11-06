package com.pbcompass.Projeto_WebServices_com_MongoDB.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
