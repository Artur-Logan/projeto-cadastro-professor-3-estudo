package com.artur.estudos.exceptions;

public class EntityNotFoundId extends RuntimeException{

    public EntityNotFoundId(String msg){
        super(msg);
    }
}
