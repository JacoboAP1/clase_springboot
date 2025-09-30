package com.breaze.clase_spring.exceptions;

public class AutorNotFoundException extends RuntimeException{
    public AutorNotFoundException() {
        super("El autor no existe");
    }

}
