package com.sqhg.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administrador")
public class Administrador {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cracha;
    private String nome;
    private Date nascimento;
    private String email;
    private String telefone;
    private String senha;
    private String confirmacaoSenha;


    @OneToMany(mappedBy = "administrador")
    private List<Questionario> questionario;


}
