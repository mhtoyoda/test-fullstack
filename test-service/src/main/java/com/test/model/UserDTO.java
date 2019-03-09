package com.test.model;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String sexo;
}
