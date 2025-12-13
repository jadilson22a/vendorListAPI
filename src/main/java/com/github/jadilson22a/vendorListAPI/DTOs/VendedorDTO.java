package com.github.jadilson22a.vendorListAPI.DTOs;

import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;

public record VendedorDTO(Integer id,
                          String nome,
                          String cnpj,
                          String email,
                          String contato,
                          FornecimentoEscopo fornecimentoEscopo,
                          String NomeCategoria,
                          String observacao)
{

}
