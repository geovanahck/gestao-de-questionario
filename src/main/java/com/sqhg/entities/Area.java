package com.sqhg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.sqhg.forms.SuperiorForm;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float codigoarea;
    @OneToMany(mappedBy = "area")
    private List<SuperiorImediato> superiorImediato;

    public SuperiorForm getForm() {
        return SuperiorForm.builder()
                .id(this.id)
                .nome(this.nome)
                .codigoarea(this.codigoarea)
                .build();
    }
}
