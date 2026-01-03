package com.github.jadilson22a.vendorListAPI.Services;

import com.github.jadilson22a.vendorListAPI.Beans.Mapear;
import com.github.jadilson22a.vendorListAPI.Beans.ValidacaoCategoria;
import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private ValidacaoCategoria validacao;
    @Autowired
    private Mapear mapear;

    @Transactional
    public CategoriaDTO CriarCategoria(CategoriaDTO dto){
        validacao.Validar(dto);

        Categoria categoriaCriada = mapear.ParaCategoria(dto);

        repository.save(categoriaCriada);
        CategoriaDTO categoriaDTOCriada = mapear.ParaCategoriaDTO(categoriaCriada);

        return categoriaDTOCriada;
    }

    public List<CategoriaDTO> BuscarTudo(){
        List<Categoria> categoriasEncontradas = repository.findAll();

        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();

        for(Categoria x: categoriasEncontradas){
            CategoriaDTO categoriaDTO = mapear.ParaCategoriaDTO(x);
            categoriaDTOList.add(categoriaDTO);
        }

        return categoriaDTOList;
    }

    public CategoriaDTO BuscarPorId(Integer id){
        Categoria categoriaEncontrada = repository.findById(id).orElse(null);

        CategoriaDTO dto = mapear.ParaCategoriaDTO(categoriaEncontrada);

        return dto;
    }

    public CategoriaDTO BuscarPorNome(String nome){
        Categoria CategoriaEncontrada = repository.findByNome(nome).orElse(null);

        CategoriaDTO dto = mapear.ParaCategoriaDTO(CategoriaEncontrada);

        return dto;
    }

    @Transactional
    public void DeletarPorId(Integer id){
        repository.deleteById(id);
    }

    @Transactional
    public void DeletarPorNome(String nome){
        Categoria CategoriasEncontradas = repository.findByNome(nome).get();

        repository.delete(CategoriasEncontradas);
    }

    @Transactional
    public CategoriaDTO Atualizar(Integer id, CategoriaDTO dto){
        validacao.Validar(dto);

        Categoria categoriaAtualizada = mapear.ParaCategoria(dto);
        categoriaAtualizada.setId(id);

        repository.save(categoriaAtualizada);

        CategoriaDTO novoDto = mapear.ParaCategoriaDTO(categoriaAtualizada);

        return novoDto;
    }
}
