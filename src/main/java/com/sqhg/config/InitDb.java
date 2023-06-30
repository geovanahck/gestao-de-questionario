package com.sqhg.config;

import com.sqhg.entities.Administrador;
import com.sqhg.services.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class InitDb {

    private final AdministradorService administradorService;

    @PostConstruct
    private void init() {
        Administrador administrador = new Administrador();
        administrador.setCracha("1234");
        administrador.setNome("Admin");
        administrador.setSenha("123456");
        administradorService.salvarAdministrador(administrador);
    }
}
