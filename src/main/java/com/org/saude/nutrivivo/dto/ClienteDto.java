package com.org.saude.nutrivivo.dto;

import lombok.Data;

public @Data class ClienteDto {

    int id;
    String nomeCliente;
    String idadeCliente;
    String endereco;
    String telefone;
    String email;
}
