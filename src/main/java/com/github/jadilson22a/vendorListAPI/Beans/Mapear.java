package com.github.jadilson22a.vendorListAPI.Beans;

import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import com.github.jadilson22a.vendorListAPI.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Mapear {

    @Autowired
    private CategoriaService categoriaService;

    public Vendedor MapearParaVendedor(VendedorDTO dto){
        CategoriaDTO categoriaDTO = categoriaService.BuscarPorNome(dto.NomeCategoria());
        Categoria categoria = categoriaDTO.mapearParaCategoria();

        Vendedor vendedor = new Vendedor();
        vendedor.setNome(dto.nome());
        vendedor.setCnpj(dto.cnpj());
        vendedor.setEmail(dto.email());
        vendedor.setContato(dto.contato());
        vendedor.setFornecimentoEscopo(dto.fornecimentoEscopo());
        vendedor.setCategoria(categoria);
        vendedor.setObservacao(dto.observacao());

        return vendedor;
    }

    public VendedorDTO MapearParaVendedorDTO(Vendedor vendedor){
        VendedorDTO dto = new VendedorDTO(
                vendedor.getId(),
                vendedor.getNome(),
                vendedor.getCnpj(),
                vendedor.getEmail(),
                vendedor.getContato(),
                vendedor.getFornecimentoEscopo(),
                vendedor.getCategoria().getNome(),
                vendedor.getObservacao()
        );

        return dto;
    }
}
