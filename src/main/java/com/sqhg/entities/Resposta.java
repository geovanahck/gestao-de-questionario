package com.sqhg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    private List<String> alternativas;
    private Integer likert;

    @ManyToOne
    @JoinColumn(name = "id_questionario")
    private Questionario questionario;

    @ManyToOne
    @JoinColumn(name = "id_questao")
    private Questao questao;
}
