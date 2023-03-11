package com.sqhg.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_area;
    private String nome;
    private Date dataCadastro;
    private Date dataInativacao;
    private int status;
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "superior_imediato")
    private SuperiorImediato superior_imediato;

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
