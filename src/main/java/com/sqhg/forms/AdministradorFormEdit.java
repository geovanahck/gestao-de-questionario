package com.sqhg.forms;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorFormEdit {

    private Long id;

    @NotEmpty(message = "* Campo obrigatório")
    private String cracha;

    private String nome;

    @NotNull(message = "* Campo obrigatório")
    @Past(message = "* Data inválida")
    private Date nascimento;

    @Email(message = "Email inválido.")
    @NotEmpty(message = "* Campo obrigatório")
    private String email;

    private String telefone;

    private String senha;

    private String confirmacaoSenha;
}
