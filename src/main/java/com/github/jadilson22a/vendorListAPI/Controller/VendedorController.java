package com.github.jadilson22a.vendorListAPI.Controller;

import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @PostMapping
    public ResponseEntity<VendedorDTO> CriarVendedor(@RequestBody VendedorDTO dto){
        VendedorDTO vendedorCriado = service.CriarVendedor(dto);
        return new ResponseEntity<>(vendedorCriado, HttpStatus.CREATED);
    }
}
