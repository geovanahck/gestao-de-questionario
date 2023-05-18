package com.sqhg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.sqhg.forms.AdministradorForm;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cracha;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nascimento;
    private String email;
    private String telefone;
    private String senha;

    @OneToMany(mappedBy = "administrador")
    private List<Questionario> questionario;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public AdministradorForm getForm() {
        AdministradorForm administradorForm = new AdministradorForm();
        administradorForm.builder()
                .cracha(this.cracha)
                .nome(this.nome)
                .nascimento(this.nascimento)
                .email(this.email)
                .telefone(this.telefone)
                .senha(this.senha)
                .confirmacaoSenha(this.senha)
                .build();
        return administradorForm;
    }
}
