package com.github.jadilson22a.vendorListAPI.Services;

import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public void CriarCategoria(Categoria categoria){
        repository.save(categoria);
    }

    public List<Categoria> BuscarTudo(){
        List<Categoria> categoriasEncontradas = repository.findAll();
        return categoriasEncontradas;
    }

    public Categoria BuscarPorId(Integer id){
        Categoria categoriaEncontrada = repository.findById(id).orElse(null);
        return categoriaEncontrada;
    }

    public List<Categoria> BuscarPorNome(String nome){
        List<Categoria> CategoriasEncontradas = repository.findByNome(nome);
        return CategoriasEncontradas;
    }

    public void DeletarPorId(Integer id){
        repository.deleteById(id);
    }

    public void DeletarPorNome(String nome){
        List<Categoria> CategoriasEncontradas = BuscarPorNome(nome);

        for(Categoria x: CategoriasEncontradas){
            repository.deleteById(x.getId());
        }
    }

    public Categoria Atualizar(Integer id, Categoria categoria){
        Categoria categoriaAtualizada = new Categoria();
        categoriaAtualizada.setId(id);
        categoriaAtualizada.setNome(categoria.getNome());

        repository.save(categoriaAtualizada);
        return categoriaAtualizada;
    }
}
