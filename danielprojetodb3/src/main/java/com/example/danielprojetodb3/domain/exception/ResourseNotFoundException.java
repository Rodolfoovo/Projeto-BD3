package com.example.danielprojetodb3.domain.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String mensagem){
        super(mensagem);
    }
}
