package com.github.jadilson22a.vendorListAPI.Beans;

import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.Exceptions.RegistroDuplicadoException;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValidacaoCategoria {

    @Autowired
    private CategoriaRepository repository;

    public void Validar(CategoriaDTO dto){

        if (categoriaExistente(dto)){
            throw new RegistroDuplicadoException("Essa categoria ja existe");
        }
    }

    public Boolean categoriaExistente(CategoriaDTO dto){

        Categoria categoria = dto.mapearParaCategoria();
        Optional<Categoria> categoriaEncontrada = repository.findByNome(dto.nome());

        if (dto.id() == null){
            return categoriaEncontrada.isPresent();
        }

        return !dto.id().equals(categoriaEncontrada.get().getId())
                && categoriaEncontrada.isPresent();
    }
}
