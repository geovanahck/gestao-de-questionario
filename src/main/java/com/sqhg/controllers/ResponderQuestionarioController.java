package com.sqhg.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String encontrarQuestoesPorModeloQuestionario(Model model,
            @PathVariable(name = "modeloquestionarioId") long modeloquestionarioId) {

        Questionario questionario = questionarioService.findById(modeloquestionarioId);
        Administrador administrador = questionario.getAdministrador();

        System.out.println(administrador.getNome());

        model.addAttribute("administrador", administrador.getNome());
        List<Questao> ListaQuestoesModeloQuestionarioQuestionario = questaoService
                .encontrarQuestoesPorModeloQuestionario(modeloquestionarioId).stream()
                .collect(Collectors.toList());

        return "responderQuestaoEl";
    }
}
