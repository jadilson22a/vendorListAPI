package com.github.jadilson22a.vendorListAPI.DTOs;

import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;

public record VendedorDTO(String nome,
                          String cnpj,
                          String email,
                          String contato,
                          FornecimentoEscopo fornecimentoEscopo,
                          Categoria categoria,
                          String observacao)
{
    public Vendedor mapearParaVendedor(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(this.nome);
        vendedor.setCnpj(this.cnpj);
        vendedor.setEmail(this.email);
        vendedor.setContato(this.contato);
        vendedor.setFornecimentoEscopo(this.fornecimentoEscopo);
        vendedor.setCategoria(this.categoria);
        vendedor.setObservacao(this.observacao);

        return vendedor;
    }

    @Override
    public String toString() {
        return "VendedorDTO{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", contato='" + contato + '\'' +
                ", fornecimentoEscopo=" + fornecimentoEscopo +
                ", categoria=" + categoria +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
