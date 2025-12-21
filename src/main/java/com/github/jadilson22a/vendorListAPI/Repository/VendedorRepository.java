package com.github.jadilson22a.vendorListAPI.Repository;

import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    List<Vendedor> findByNome(String nome);
    Optional<Vendedor> findByNomeAndFornecimentoEscopoAndCategoria(String nome,
                                                                  FornecimentoEscopo fornecimentoEscopo,
                                                                  Categoria categoria);
}
