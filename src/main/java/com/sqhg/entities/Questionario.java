package com.sqhg.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "id_modeloQuestionario")
    private ModeloQuestionario modeloQuestionario;

    @ManyToMany( mappedBy = "questionario")
    private List<SuperiorImediato> superiorImediato;

    @OneToMany(mappedBy = "questionario")
    private List<Resposta> resposta;
}
