package com.sqhg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class Opcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_opcao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "opcao")
    private Opcao opcao;

    public int getId_opcao() {
        return id_opcao;
    }

    public void setId_opcao(int id_opcao) {
        this.id_opcao = id_opcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
