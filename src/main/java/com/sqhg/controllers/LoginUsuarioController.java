package com.sqhg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.sqhg.entities.Usuario;
import com.sqhg.repositories.UsuarioRepository;

@Controller

public class LoginUsuarioController {
    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Autowired
    @GetMapping(value = "/loginUsuario")
    public String loginUsuario() {
        return "loginUsuario";
    }

    @PostMapping(value = "/logarUsuario")
    public String logarUsuario(Model model, Usuario usuarioParam) {
        Usuario usuario = this.repositoryUsuario.LoginUsuario(usuarioParam.getChaveDeAcesso());
        if (usuario != null) {
            return "sucessoTesteUsuario";
        }
        model.addAttribute("erro", "Chave inválida");
        return "loginUsuario";
    }
    
}
