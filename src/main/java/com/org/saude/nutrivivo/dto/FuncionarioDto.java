package com.org.saude.nutrivivo.dto;

import lombok.Data;

public class FuncionarioDto {


    public @Data
    class Funcionario {

        int id;
        String nomeFuncionario;
        String funcaoFuncionario;
        String telefoneFuncionario;
        String emailFuncionario;

    }
}
