package com.sqhg.forms;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AdministradorForm {

    @NotEmpty(message = "* Campo obrigatório")
    private String cracha;

    @NotEmpty(message = "* Campo obrigatório")
    private String nome;
    @NotNull(message = "* Campo obrigatório")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;


    @Email(message = "Email inválido.")
    @NotEmpty(message = "* Campo obrigatório")
    private String email;

    private String telefone;

    @NotEmpty(message = "* Campo obrigatório")
    @Size(min = 6, message = "Senha deve conter ao menos seis caracteres.")
    private String senha;

    @NotEmpty(message = "Confirme a senha.")
    private String confirmacaoSenha;
}
