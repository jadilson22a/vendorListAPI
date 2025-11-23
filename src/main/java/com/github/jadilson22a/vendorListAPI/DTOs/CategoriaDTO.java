package com.github.jadilson22a.vendorListAPI.DTOs;

import com.github.jadilson22a.vendorListAPI.Models.Categoria;

public record CategoriaDTO(Integer id, String nome) {

    public Categoria mapearParaCategoria(){
        Categoria categoria = new Categoria();
        categoria.setId(this.id);
        categoria.setNome(this.nome);
        return categoria;
    }
}
