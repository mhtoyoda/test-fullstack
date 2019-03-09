package com.test.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Data
public class UserDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String sexo;
}
