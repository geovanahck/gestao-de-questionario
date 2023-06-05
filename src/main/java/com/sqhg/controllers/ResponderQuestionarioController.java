package com.sqhg.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questao;
import com.sqhg.entities.Questionario;
import com.sqhg.repositories.QuestionarioRepository;
import com.sqhg.services.QuestaoService;
import com.sqhg.services.QuestionarioService;

@RestController
@RequestMapping("/questionario")
public class ResponderQuestionarioController {

    private QuestionarioService questionarioService;
    private QuestaoService questaoService;

    @Autowired
    public ResponderQuestionarioController(QuestionarioService questionarioService, QuestaoService questaoService) {
        this.questionarioService = questionarioService;
        this.questaoService = questaoService;
    }

    @GetMapping("/{modeloquestionarioId}")
    public List<Questao> encontrarQuestoesPorModeloQuestionario(
            @PathVariable(name = "modeloquestionarioId") long modeloquestionarioId) {

        Questionario questionario = questionarioService.findById(modeloquestionarioId);
        Administrador administrador = questionario.getAdministrador();
        System.out.println(administrador.getNome());

        List<Questao> ListaQuestoesModeloQuestionarioQuestionario = questaoService
                .encontrarQuestoesPorModeloQuestionario(modeloquestionarioId).stream()
                .collect(Collectors.toList());

        return ListaQuestoesModeloQuestionarioQuestionario;
    }
}
