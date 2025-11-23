package com.github.jadilson22a.vendorListAPI.Controller;

import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
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
    public void CriarCategoria(@RequestBody CategoriaDTO dto){
        service.CriarCategoria(dto);
    }

    @GetMapping()
    public List<CategoriaDTO> BuscarTudo(){
        return service.BuscarTudo();
    }

    @GetMapping("{id}")
    public CategoriaDTO BuscarPorId(@PathVariable Integer id){
        return service.BuscarPorId(id);
    }

    @GetMapping("nome/{nome}")
    public List<CategoriaDTO> BuscarPorNome(@PathVariable String nome){
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
    public CategoriaDTO Atualizar(@PathVariable Integer id,
                               @RequestBody Categoria categoriaAtualizada){
        return service.Atualizar(id, categoriaAtualizada);
    }
}
