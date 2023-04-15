package com.sqhg.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtualizarModeloQuestionarioRequest {
    private Long id;
    private String nomeQuestionario;
    private String descricaoQuestionario;
    private String questao0a10;
    private String questaoAlternativa;
    private String questaoMultiplaEscolha;
    private String questaoAberta;
}
