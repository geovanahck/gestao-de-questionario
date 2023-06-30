package com.sqhg.controllers;

import java.util.List;

import com.sqhg.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqhg.services.OpcaoService;
import com.sqhg.services.QuestionarioService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/{codigoQuestionario}")
@AllArgsConstructor
public class LoginResponderQuestionarioController {

    private final QuestionarioService questionarioService;

    @GetMapping
    public String irParaPrimeiraQuestaoQuestionario(Model model,
            @PathVariable(name = "codigoQuestionario") int codigoQuestionario) {
        Questionario questionario = questionarioService.acharQuestionarioPorCodigo(codigoQuestionario);
        if (questionario == null) {
            return "redirect:/login";
        }

        ModeloQuestionario modeloQuestionario = questionario.getModeloQuestionario();
        Questao primeiraQuestao = modeloQuestionario.getQuestoes().get(0);
        model.addAttribute("questionario", questionario);
        model.addAttribute("questao", primeiraQuestao);
        model.addAttribute("modeloQuestionario", modeloQuestionario);

        if (primeiraQuestao.getTipo().equals(TipoQuestao.ABERTA)) {
            return "responderQuestaoAberta";
        } else if (primeiraQuestao.getTipo().equals(TipoQuestao.ALTERNATIVAS)
                || primeiraQuestao.getTipo().equals(TipoQuestao.MULTIPLA)) {
            model.addAttribute("opcoes", primeiraQuestao.getOpcoes());
            return "responderQuestaoAlternativas";
        } else {
            return "responderQuestaoEL";
        }
    }
}
