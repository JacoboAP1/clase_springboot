package com.breaze.clase_spring.exceptions;

public class AutorNotFoundException extends RuntimeException{
    public AutorNotFoundException(String message) {
        super(message);
    }

}
