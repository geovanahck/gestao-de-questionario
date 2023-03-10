package com.sqhg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_questao;
    private String descricao;
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "modelo_questionario")
    private ModeloQuestionario modelo_questionario;

    @OneToMany
    @JoinColumn(name = "opcao")
    private Opcao opcao;

    public int getId_questao() {
        return id_questao;
    }

    public void setId_questao(int id_questao) {
        this.id_questao = id_questao;
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
}
