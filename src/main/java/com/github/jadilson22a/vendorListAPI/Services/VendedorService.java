package com.github.jadilson22a.vendorListAPI.Services;

import com.github.jadilson22a.vendorListAPI.Beans.Mapear;
import com.github.jadilson22a.vendorListAPI.Beans.ValidacaoVendedor;
import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import com.github.jadilson22a.vendorListAPI.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private Mapear mapear;

    @Autowired
    private ValidacaoVendedor validacaoVendedor;

    @Transactional
    public VendedorDTO CriarVendedor(VendedorDTO dto){
        validacaoVendedor.validar(dto);

        Vendedor vendedor = mapear.ParaVendedor(dto);
        Vendedor vendedorSalvo = repository.save(vendedor);

        return mapear.ParaVendedorDTO(vendedorSalvo);
    }

    public VendedorDTO BuscarVendedorPorId(Integer id){
        Vendedor vendedorEncontrado = repository.findById(id).orElse(null);
        VendedorDTO dto = mapear.ParaVendedorDTO(vendedorEncontrado);
        return dto;
    }

    public List<VendedorDTO> BuscarPorNome(String nome){
        List<Vendedor> vendedorEncontrado = repository.findByNome(nome);

        List<VendedorDTO> vendedoresDTOS = new ArrayList<>();
        for(Vendedor x: vendedorEncontrado){
            VendedorDTO dto = mapear.ParaVendedorDTO(x);
            vendedoresDTOS.add(dto);
        }

        return vendedoresDTOS;
    }

    @Transactional
    public VendedorDTO Atualizar(VendedorDTO dto, Integer id){
        validacaoVendedor.validar(dto);

        Vendedor vendedor = mapear.ParaVendedor(dto);
        vendedor.setId(id);
        Vendedor vendedorSalvo = repository.save(vendedor);

        return mapear.ParaVendedorDTO(vendedorSalvo);
    }

    @Transactional
    public void Deletar(Integer id){
        repository.deleteById(id);
    }
}
