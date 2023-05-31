package com.sqhg.forms;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class SuperiorForm {
    private Long id;

    @NotEmpty(message = "* Campo obrigatório")
    private String nome;

    @NotNull(message = "* Campo obrigatório")
    private float codigoarea;

}
