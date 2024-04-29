package com.example.danielprojetodb3.domain.exception;

public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String mensagem){
        super(mensagem);
    }
}
