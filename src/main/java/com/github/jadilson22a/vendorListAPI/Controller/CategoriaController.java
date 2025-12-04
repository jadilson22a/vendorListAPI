package com.github.jadilson22a.vendorListAPI.Controller;

import com.github.jadilson22a.vendorListAPI.DTOs.CategoriaDTO;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.RespostaErro;
import com.github.jadilson22a.vendorListAPI.Services.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.jadilson22a.vendorListAPI.Models.RespostaErro.erroPadrao;

@Slf4j
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping()
    public ResponseEntity<Object> CriarCategoria(@RequestBody CategoriaDTO dto){
        CategoriaDTO dtoCriado = service.CriarCategoria(dto);
        return new ResponseEntity(dtoCriado, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> BuscarTudo(){
        return new ResponseEntity<>(service.BuscarTudo(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaDTO> BuscarPorId(@PathVariable Integer id){
        return new ResponseEntity(service.BuscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<List<CategoriaDTO>> BuscarPorNome(@PathVariable String nome){
        return new ResponseEntity<>(service.BuscarPorNome(nome), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeletarPorId(@PathVariable Integer id){
        service.DeletarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("nome/{nome}")
    public ResponseEntity<Object> DeletarPorNome(@PathVariable String nome){
        service.DeletarPorNome(nome);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriaDTO> Atualizar(@PathVariable Integer id,
                               @RequestBody Categoria categoriaAtualizada){
        return new ResponseEntity<>(service.Atualizar(id, categoriaAtualizada),
                                    HttpStatus.ACCEPTED);
    }
}
