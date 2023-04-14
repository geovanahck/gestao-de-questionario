package com.sqhg.models;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Data
@Entity
public class Questionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nomeQuestionario;
    @Column(unique = true)
    private String descricaoQuestionario;
    private String questao0a10;
    private String questaoAlternativa;
    private String questaoMultiplaEscolha;
    private String questaoAberta;
    private Instant dataCadastro;
    private Instant ultimaAtualizacao;
}
