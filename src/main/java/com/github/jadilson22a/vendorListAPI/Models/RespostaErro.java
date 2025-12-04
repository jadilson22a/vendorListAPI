package com.github.jadilson22a.vendorListAPI.Models;

import com.github.jadilson22a.vendorListAPI.DTOs.ErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public record RespostaErro(int status, String mensagem, List<ErroDto> erros) {
    public static RespostaErro erroPadrao(String mensagem, List<ErroDto> erros){
        return new RespostaErro(HttpStatus.BAD_REQUEST.value(), mensagem, erros);
    }

    public static RespostaErro erroConflito(String mensagem, List<ErroDto> erros){
        return new RespostaErro(HttpStatus.CONFLICT.value(), mensagem, erros);
    }

    public static RespostaErro erroValidacao(String mensagem, List<ErroDto> erros){
        return new RespostaErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), mensagem, erros);
    }
}
