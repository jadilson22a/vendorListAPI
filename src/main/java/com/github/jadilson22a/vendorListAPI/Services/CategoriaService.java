package com.github.jadilson22a.vendorListAPI.Services;

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

    public CategoriaDTO CriarCategoria(CategoriaDTO dto){
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

    public List<CategoriaDTO> BuscarPorNome(String nome){
        List<Categoria> CategoriasEncontradas = repository.findByNome(nome);

        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();

        for(Categoria x: CategoriasEncontradas){
            CategoriaDTO categoriaDTO = new CategoriaDTO(x.getId(), x.getNome());
            categoriaDTOList.add(categoriaDTO);
        }

        return categoriaDTOList;
    }

    public void DeletarPorId(Integer id){
        repository.deleteById(id);
    }

    public void DeletarPorNome(String nome){
        List<Categoria> CategoriasEncontradas = repository.findByNome(nome);

        for(Categoria x: CategoriasEncontradas){
            repository.deleteById(x.getId());
        }
    }

    public CategoriaDTO Atualizar(Integer id, Categoria categoria){
        Categoria categoriaAtualizada = new Categoria();
        categoriaAtualizada.setId(id);
        categoriaAtualizada.setNome(categoria.getNome());

        repository.save(categoriaAtualizada);

        CategoriaDTO dto = new CategoriaDTO(categoriaAtualizada.getId(),
                                            categoriaAtualizada.getNome());
        return dto;
    }
}
