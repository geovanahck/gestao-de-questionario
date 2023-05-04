package com.sqhg.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AdministradorForm {

    @NotBlank(message = "Crachá é um campo obrigatório.")
    private String cracha;

    @NotBlank(message = "Nome é um campo obrigatório.")
    private String nome;

    @NotBlank(message = "Data de nascimento é um campo obrigatório.")
    private Date nascimento;

    @Email(message = "Email inválido.")
    @NotBlank(message = "Email é um campo obrigatório.")
    private String email;

    private String telefone;

    @NotBlank(message = "Senha é um campo obrigatório.")
    @Size(min = 6, message = "Senha deve conter ao menos seis caracteres.")
    private String senha;

    @NotBlank(message = "Confirme a senha.")
    private String confirmacaoSenha;
}
