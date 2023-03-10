package com.sqhg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "questionario")
public class Questionario {
        
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_questionario; 
    private String nome;
    private String descricao;

        
    @ManyToOne
    @JoinColumn(name = "administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "modelo_questionario_id")
    private ModeloQuestionario modeloQuestionario;

    @ManyToMany( mappedBy = "superior_imediato")
    private List<SuperiorImediato> superior_imediato;

    @ManyToOne
    @JoinColumn(name = "resposta")
    private Resposta resposta;

    public int getId_questionario() {
        return id_questionario;
    }

    public void setId_questionario(int id_questionario) {
        this.id_questionario = id_questionario;
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
}
