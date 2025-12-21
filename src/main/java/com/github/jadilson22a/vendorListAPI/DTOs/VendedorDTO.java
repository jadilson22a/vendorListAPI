package com.github.jadilson22a.vendorListAPI.DTOs;

import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VendedorDTO(Integer id,
                          @NotBlank String nome,
                          @NotBlank String cnpj,
                          @NotBlank String email,
                          String contato,
                          @NotNull FornecimentoEscopo fornecimentoEscopo,
                          @NotBlank String NomeCategoria,
                          String observacao)
{

}
