package com.sqhg.controllers;

import org.hibernate.result.ResultSetOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/logar")
    public String logar() {
        System.out.println("Teste");
        return "logar";
    }



}
