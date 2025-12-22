package com.github.jadilson22a.vendorListAPI.Beans;

import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import com.github.jadilson22a.vendorListAPI.Repository.CategoriaRepository;
import com.github.jadilson22a.vendorListAPI.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapear {

    @Autowired
    private CategoriaRepository repository;

    public Vendedor ParaVendedor(VendedorDTO dto){
        Categoria categoria = repository.findByNome(dto.NomeCategoria()).orElse(null);

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

    public VendedorDTO ParaVendedorDTO(Vendedor vendedor){
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

    public Categoria ParaCategoria(CategoriaDTO dto){

        Categoria categoria = new Categoria();
        categoria.setId(dto.id());
        categoria.setNome(dto.nome());

        return categoria;
    }

    public CategoriaDTO ParaCategoriaDTO(Categoria categoria){

        CategoriaDTO dto = new CategoriaDTO(categoria.getId(), categoria.getNome());

        return dto;
    }
}
