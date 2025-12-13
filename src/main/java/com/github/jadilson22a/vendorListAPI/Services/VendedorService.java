package com.github.jadilson22a.vendorListAPI.Services;

import com.github.jadilson22a.vendorListAPI.Beans.Mapear;
import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import com.github.jadilson22a.vendorListAPI.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private Mapear mapear;

    public VendedorDTO CriarVendedor(VendedorDTO dto){
        Vendedor vendedor = mapear.MapearParaVendedor(dto);
        Vendedor vendedorSalvo = repository.save(vendedor);

        return mapear.MapearParaVendedorDTO(vendedorSalvo);
    }
}
