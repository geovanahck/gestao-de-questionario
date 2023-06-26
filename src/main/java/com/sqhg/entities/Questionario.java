package com.sqhg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "questionario")
public class Questionario {
        
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "id_modeloQuestionario")
    private ModeloQuestionario modeloQuestionario;

    @ManyToMany( mappedBy = "questionario")
    private List<SuperiorImediato> superiorImediato;

    @ManyToOne
    @JoinColumn(name = "id_resposta")
    private Resposta resposta;
}
