package com.sqhg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class Opcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "opcao")
    private Opcao opcao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }
}
