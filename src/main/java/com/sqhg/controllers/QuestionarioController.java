package com.sqhg.controllers;

import com.sqhg.forms.AdministradorForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/questionario")
@AllArgsConstructor
public class QuestionarioController {

    @GetMapping(value="/enviar")
    public String enviarQuestionario(Model model) {
        model.addAttribute("questionario", new AdministradorForm());
        return "envioQuestionario";
    }
}
