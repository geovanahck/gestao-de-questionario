package com.sqhg.forms;

import java.sql.Date;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
public class AdministradorForm {
    private Long id;

    @NotEmpty(message = "* Campo obrigatório")
    private String cracha;

    private String nome;

    @Past(message = "* Data inválida. Deve ser uma data no passado")
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
