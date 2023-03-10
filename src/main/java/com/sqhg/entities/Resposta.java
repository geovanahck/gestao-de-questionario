package com.sqhg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resposta;
    private String resposta;

    @OneToMany
    @JoinColumn(name = "questionario")
    private Questionario questionario;

    @ManyToOne
    @JoinColumn(name = "questao")
    private Questao questao;

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
