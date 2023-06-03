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
@Table(name = "modeloQuestionario")
public class ModeloQuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "modeloQuestionario")
    private List<Questionario> questionario;

   // @OneToMany(mappedBy = "modeloQuestionario")
    //private List<Questao> questao;
}
