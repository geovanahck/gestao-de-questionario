package com.sqhg.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modeloQuestionario")
public class ModeloQuestionario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "modeloQuestionario")
    private List<Questionario> questionario;

    @OneToMany(mappedBy = "modeloQuestionario")
    private List<Questao> questao;

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

    public List<Questionario> getQuestionario() {
        return questionario;
    }

    public void setQuestionario(List<Questionario> questionario) {
        this.questionario = questionario;
    }
}
