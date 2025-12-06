package com.github.jadilson22a.vendorListAPI.Repository;

import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNome(String nome);
}
