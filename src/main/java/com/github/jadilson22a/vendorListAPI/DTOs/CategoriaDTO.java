package com.github.jadilson22a.vendorListAPI.DTOs;

import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(Integer id, @NotBlank String nome) {
}
