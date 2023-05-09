package com.sqhg.entities;

import java.util.List;

import com.sqhg.model.Questao;

import jakarta.persistence.*;

@Entity
@Table(name = "modeloQuestionario")
public class ModeloQuestionario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "modeloQuestionario")
    private List<Questionario> questionario;

    @OneToMany(mappedBy = "modeloQuestionario")
    private List<Questao> questao;

    public int getId() {
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