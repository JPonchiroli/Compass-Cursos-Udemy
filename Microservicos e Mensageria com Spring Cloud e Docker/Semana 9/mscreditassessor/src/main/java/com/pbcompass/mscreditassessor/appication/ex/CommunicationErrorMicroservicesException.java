package com.pbcompass.mscreditassessor.appication.ex;

public class CommunicationErrorMicroservicesException extends Exception{

    private Integer status;

    public CommunicationErrorMicroservicesException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
