package com.github.jadilson22a.vendorListAPI.Exceptions;

import com.github.jadilson22a.vendorListAPI.DTOs.ErroDto;
import com.github.jadilson22a.vendorListAPI.Models.RespostaErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespostaErro> handleJsonErrors(HttpMessageNotReadableException ex) {

        RespostaErro erro = RespostaErro.erroPadrao(
                "JSON inválido ou mal formatado",
                List.of(new ErroDto("body", ex.getMostSpecificCause().getMessage()))
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RespostaErro> handleRuntime(RuntimeException ex) {

        RespostaErro erro = RespostaErro.erroPadrao(
                ex.getMessage(), List.of(new ErroDto(null, ex.getMessage()))
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}

