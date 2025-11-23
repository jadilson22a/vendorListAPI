package com.github.jadilson22a.vendorListAPI.Controller;

import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping()
    public void CriarCategoria(@RequestBody Categoria categoria){
        service.CriarCategoria(categoria);
    }

    @GetMapping()
    public List<Categoria> BuscarTudo(){
        return service.BuscarTudo();
    }

    @GetMapping("{id}")
    public Categoria BuscarPorId(@PathVariable Integer id){
        return service.BuscarPorId(id);
    }

    @GetMapping("nome/{nome}")
    public List<Categoria> BuscarPorNome(@PathVariable String nome){
        return service.BuscarPorNome(nome);
    }

    @DeleteMapping("{id}")
    public void DeletarPorId(@PathVariable Integer id){
        service.DeletarPorId(id);
    }

    @DeleteMapping("nome/{nome}")
    public void DeletarPorNome(@PathVariable String nome){
        service.DeletarPorNome(nome);
    }

    @PutMapping("{id}")
    public Categoria Atualizar(@PathVariable Integer id,
                               @RequestBody Categoria categoriaAtualizada){
        return service.Atualizar(id, categoriaAtualizada);
    }
}
