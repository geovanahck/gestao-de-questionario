package com.sqhg.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "superiorImediato")
public class SuperiorImediato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;

    @ManyToMany (mappedBy = "questionario")
    private List<Questionario> questionario;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Questionario> getQuestionario() {
        return questionario;
    }

    public void setQuestionario(List<Questionario> questionario) {
        this.questionario = questionario;
    }
}
