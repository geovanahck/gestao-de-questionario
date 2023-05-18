package com.sqhg.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AdministradorForm {

    @NotEmpty(message = "* Campo obrigatório")
    private String cracha;

    private String nome;

    @NotNull(message = "* Campo obrigatório")
    private Date nascimento;


    @Email(message = "Email inválido.")
    @NotEmpty(message = "* Campo obrigatório")
    private String email;

    private String telefone;

    @Size(min = 6, message = "Senha deve conter ao menos seis caracteres")
    private String senha;

    @NotEmpty(message = "Confirme a senha")
    private String confirmacaoSenha;
}
