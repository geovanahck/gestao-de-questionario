package com.sqhg.entities;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questionario")
public class Questionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String codigo;
    @DateTimeFormat(pattern = "dd/MMM/yyyy")
    private Date dataInicio;
    @DateTimeFormat(pattern = "dd/MMM/yyyy")
    private Date dataFim;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "id_modeloQuestionario")
    private ModeloQuestionario modeloQuestionario;

    @ManyToMany(mappedBy = "questionario")
    private List<SuperiorImediato> superiorImediato;

    @OneToMany(mappedBy = "questionario")
    private List<Resposta> resposta;
}
