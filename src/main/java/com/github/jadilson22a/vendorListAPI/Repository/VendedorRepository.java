package com.github.jadilson22a.vendorListAPI.Repository;

import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
