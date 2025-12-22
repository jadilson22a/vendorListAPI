package com.github.jadilson22a.vendorListAPI.Beans;

import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Exceptions.RegistroDuplicadoException;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import com.github.jadilson22a.vendorListAPI.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidacaoVendedor {

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private Mapear map;

    public void validar(VendedorDTO dto){

        if (VendedorExiste(dto)){
            throw new RegistroDuplicadoException("Esse vendedor ja existe!");
        }

    }

    public boolean VendedorExiste(VendedorDTO dto){

        Vendedor vendedor = map.ParaVendedor(dto);

        Optional<Vendedor> vendedorEncontrado =
                repository.findByNomeAndFornecimentoEscopoAndCategoria(
                        vendedor.getNome(),
                        vendedor.getFornecimentoEscopo(),
                        vendedor.getCategoria()
                );

        if(vendedor.getId() == null){
            return vendedorEncontrado.isPresent();
        }

        return !dto.id().equals(vendedorEncontrado.get().getId()) && vendedorEncontrado.isPresent();
    }
}
