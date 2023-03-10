package com.sqhg.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "superior_imediato")
public class SuperiorImediato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_superior;
    private String nome;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;

    @ManyToMany (mappedBy = "questionario")
    private List<Questionario> questionario;

    public int getId_superior() {
        return id_superior;
    }

    public void setId_superior(int id_superior) {
        this.id_superior = id_superior;
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
}
