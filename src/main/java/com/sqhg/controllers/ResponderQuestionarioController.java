package com.sqhg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questao;
import com.sqhg.entities.Questionario;
import com.sqhg.services.QuestaoService;
import com.sqhg.services.QuestionarioService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/questionario")
@AllArgsConstructor
public class ResponderQuestionarioController {

    private QuestionarioService questionarioService;
    private QuestaoService questaoService;

    @GetMapping("/{modeloquestionarioId}")
    public String findQuestionsByQuestionnaireModel(Model model,
            @PathVariable(name = "modeloquestionarioId") long questionarioModelId) {
        Questionario questionario = questionarioService.findById(questionarioModelId);
        Administrador administrador = questionario.getAdministrador();
        model.addAttribute("administrator", administrador.getNome());

        Questao question = questaoService
                .acharQuestoesPorModeloQuestionario(questionarioModelId);

        model.addAttribute("question", question);

        if (question.getTipo() == 3) {
            return "responderQuestaoAberta";
        }

        if (question.getTipo() == 2) {
            question.getOpcao().forEach(opcao -> {
                System.out.println("Opcao: " + opcao.getDescricao());
            });
            return "responderQuestaoAlternativa";
        }

        return "responderQuestaoEl";
    }
}
