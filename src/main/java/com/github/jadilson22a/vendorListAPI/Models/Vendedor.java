package com.github.jadilson22a.vendorListAPI.Models;

import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendedor")
@Data
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "email")
    private String email;

    @Column(name = "contato", precision = 20)
    private String contato;

    @Enumerated(EnumType.STRING)
    @Column(name = "fornecimento_escopo")
    private FornecimentoEscopo fornecimentoEscopo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "observacao")
    private String observacao;
}
