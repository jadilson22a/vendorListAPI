package com.github.jadilson22a.vendorListAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria_de_venda")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;
}
