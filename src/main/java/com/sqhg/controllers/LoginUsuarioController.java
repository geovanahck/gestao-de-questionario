package com.sqhg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginUsuarioController {

    @GetMapping(value = "/login/reponderquestionario")
    public String loginUsuario() {
        return "loginUsuario";
    }
}
