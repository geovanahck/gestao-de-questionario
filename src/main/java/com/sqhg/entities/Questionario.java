package com.sqhg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "questionario")
public class Questionario {
        
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ModeloQuestionario getModeloQuestionario() {
        return modeloQuestionario;
    }

    public void setModeloQuestionario(ModeloQuestionario modeloQuestionario) {
        this.modeloQuestionario = modeloQuestionario;
    }

    public List<SuperiorImediato> getSuperiorImediato() {
        return superiorImediato;
    }

    public void setSuperiorImediato(List<SuperiorImediato> superiorImediato) {
        this.superiorImediato = superiorImediato;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
}
