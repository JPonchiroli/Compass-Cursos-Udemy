package com.pbcompass.mscreditassessor.appication.ex;

public class ClientDataNotFoundException extends Exception{
    public ClientDataNotFoundException(){
        super("Client data not found for informed cpf");
    }
}
