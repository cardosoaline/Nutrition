package com.org.saude.nutrivivo.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "cliente")
public @Data class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente",nullable = false)
    private String nomeCliente;

    @Column(name = "idade_cliente",nullable = false)
    private String idadeCliente;

    @Column(name = "endereco",nullable = false)
    private String endereco;

    @Column(name = "telefone",nullable = false)
    private String telefone;

    @Column(name = "email",nullable = false)
    private String email;

}
