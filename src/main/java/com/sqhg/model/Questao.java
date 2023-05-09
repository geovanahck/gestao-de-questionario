package com.sqhg.model;

import jakarta.persistence.*;

import java.util.List;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Opcao;

@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "id_modeloQuestionario")
    private ModeloQuestionario modeloQuestionario;

    @OneToMany(mappedBy = "questao")
    private List<Opcao> opcao;

    public Questao(Long id, String descricao, int tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Questao() {

    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ModeloQuestionario getModeloQuestionario() {
        return modeloQuestionario;
    }

    public void setModeloQuestionario(ModeloQuestionario modeloQuestionario) {
        this.modeloQuestionario = modeloQuestionario;
    }

    public List<Opcao> getOpcao() {
        return opcao;
    }

    public void setOpcao(List<Opcao> opcao) {
        this.opcao = opcao;
    }
}
