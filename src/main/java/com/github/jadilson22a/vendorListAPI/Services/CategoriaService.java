package com.github.jadilson22a.vendorListAPI.Services;

import com.github.jadilson22a.vendorListAPI.Beans.ValidacaoCategoria;
import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private ValidacaoCategoria validacao;

    public CategoriaDTO CriarCategoria(CategoriaDTO dto){
        validacao.Validar(dto);
        Categoria categoriaCriada = repository.save(dto.mapearParaCategoria());
        CategoriaDTO categoriaDTOCriada = new CategoriaDTO(categoriaCriada.getId(),
                                                            categoriaCriada.getNome());

        return categoriaDTOCriada;
    }

    public List<CategoriaDTO> BuscarTudo(){
        List<Categoria> categoriasEncontradas = repository.findAll();

        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();

        for(Categoria x: categoriasEncontradas){
            CategoriaDTO categoriaDTO = new CategoriaDTO(x.getId(), x.getNome());
            categoriaDTOList.add(categoriaDTO);
        }

        return categoriaDTOList;
    }

    public CategoriaDTO BuscarPorId(Integer id){
        Categoria categoriaEncontrada = repository.findById(id).orElse(null);

        CategoriaDTO dto = new CategoriaDTO(categoriaEncontrada.getId(),
                                            categoriaEncontrada.getNome());

        return dto;
    }

    public CategoriaDTO BuscarPorNome(String nome){
        Categoria CategoriaEncontrada = repository.findByNome(nome).orElse(null);

        CategoriaDTO dto = new CategoriaDTO(CategoriaEncontrada.getId(),
                CategoriaEncontrada.getNome());

        return dto;
    }

    public void DeletarPorId(Integer id){
        repository.deleteById(id);
    }

    public void DeletarPorNome(String nome){
        Categoria CategoriasEncontradas = repository.findByNome(nome).get();

        repository.delete(CategoriasEncontradas);
    }

    public CategoriaDTO Atualizar(Integer id, CategoriaDTO dto){
        validacao.Validar(dto);

        Categoria categoriaAtualizada = dto.mapearParaCategoria();
        categoriaAtualizada.setId(id);
        categoriaAtualizada.setNome(dto.nome());

        repository.save(categoriaAtualizada);

        CategoriaDTO novoDto = new CategoriaDTO(categoriaAtualizada.getId(),
                categoriaAtualizada.getNome());

        return novoDto;
    }
}
