package com.org.saude.nutrivivo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public @Data class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_funcionario",nullable = false)
    private String nomeFuncionario;

    @Column(name = "funcao_funcionario",nullable = false)
    private String funcaoFuncionario;

    @Column(name = "telefone_funcionario",nullable = false)
    private String telefoneFuncionario;

    @Column(name = "email_funcionario",nullable = false)
    private String emailFuncionario;

}
