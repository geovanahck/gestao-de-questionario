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
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    @ManyToOne
    @JoinColumn(name = "id_modeloQuestionario")
    private ModeloQuestionario modeloQuestionario;

    @OneToMany(mappedBy = "questao")
    private List<Opcao> opcoes;
}
