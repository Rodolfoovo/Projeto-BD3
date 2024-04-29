package com.example.danielprojetodb3.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.danielprojetodb3.common.ConversorData;
import com.example.danielprojetodb3.domain.exception.BadRequestException;
import com.example.danielprojetodb3.domain.exception.ResourseNotFoundException;
import com.example.danielprojetodb3.domain.model.ErroResposta;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ErroResposta> 
    handlerResourseNotFoundException(ResourseNotFoundException ex){
        String dataHora = ConversorData.converterDateParaDatahora(new Date());
        ErroResposta erro = new ErroResposta
        (dataHora, HttpStatus.NOT_FOUND.value(), "NOT FOUND", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErroResposta> 
    handlerBadRequestException(BadRequestException ex){
        String dataHora = ConversorData.converterDateParaDatahora(new Date());
        ErroResposta erro = new ErroResposta
        (dataHora, HttpStatus.BAD_REQUEST.value(), "NOT FOUND", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> 
    handlerException(Exception ex){
        String dataHora = ConversorData.converterDateParaDatahora(new Date());
        ErroResposta erro = new ErroResposta
        (dataHora, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
