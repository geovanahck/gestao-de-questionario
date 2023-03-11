package com.sqhg.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String resposta;

    @OneToMany(mappedBy = "questionario")
    private List<Questionario> questionario;

    @ManyToOne
    @JoinColumn(name = "questao")
    private Questao questao;

    public int getId() {
        return id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<Questionario> getQuestionario() {
        return questionario;
    }

    public void setQuestionario(List<Questionario> questionario) {
        this.questionario = questionario;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
