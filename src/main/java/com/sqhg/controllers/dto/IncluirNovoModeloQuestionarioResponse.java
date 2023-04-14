package com.sqhg.controllers.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class IncluirNovoModeloQuestionarioResponse {
    private Long id;
    private String nomeQuestionario;
    private String descricaoQuestionario;
    private String questao0a10;
    private String questaoAlternativa;
    private String questaoMultiplaEscolha;
    private String questaoAberta;
    private Instant dataCadastro;
    private Instant ultimaAtualizacao;
}
