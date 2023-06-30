package com.sqhg.controllers;

import com.sqhg.entities.Questionario;
import com.sqhg.services.QuestionarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class LoginController {

    private final QuestionarioService questionarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-usuario")
    public String loginRespondente() {
        return "loginUsuario";
    }

    @PostMapping("/login-usuario")
    public String loginRespondente(Model model, @RequestParam(name = "codigoQuestionario") String codigoQuestionario) {
        Questionario questionario = questionarioService.acharQuestionarioPorCodigo(codigoQuestionario);
        if (questionario == null) {
            model.addAttribute("erro", "Chave incorreta!");
            return "loginUsuario";
        }
        return String.format("redirect:/questionario/responder/%s/%d", codigoQuestionario, 1);
    }
}
