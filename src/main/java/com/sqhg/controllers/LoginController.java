package com.sqhg.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

@Controller

public class LoginController {
    @Autowired
    private AdministradorRepository repository;

    @Autowired
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/logar")
    public String Login(Model model, Administrador admParam) {
        Administrador adm = this.repository.Login(admParam.getCracha(),
                admParam.getSenha());
        if (adm != null) {
            System.out.println("Login efetuado");
           return "listaAdm";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login";
    }

}