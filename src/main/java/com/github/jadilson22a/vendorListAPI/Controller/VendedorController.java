package com.github.jadilson22a.vendorListAPI.Controller;

import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Services.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @PostMapping
    public ResponseEntity<VendedorDTO> CriarVendedor(@Valid @RequestBody VendedorDTO dto){
        VendedorDTO vendedorCriado = service.CriarVendedor(dto);
        return new ResponseEntity<>(vendedorCriado, HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<VendedorDTO> BuscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(service.BuscarVendedorPorId(id), HttpStatus.OK);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<List<VendedorDTO>> BuscarPorNome(@PathVariable String nome){
        return new ResponseEntity<>(service.BuscarPorNome(nome), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<VendedorDTO> Atualizar(@Valid @RequestBody VendedorDTO dto,
                                                 @PathVariable Integer id){
        return new ResponseEntity<>(service.Atualizar(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void Deletar(@PathVariable Integer id){
        service.Deletar(id);
    }
}
