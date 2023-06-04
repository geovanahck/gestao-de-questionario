package com.sqhg.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sqhg.entities.Questao;
import com.sqhg.services.QuestaoService;

@Controller
public class ResponderQuestionarioController {
    private QuestaoService questaoService;

    public ResponderQuestionarioController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @GetMapping(value = "/questoes/{modeloquestionarioId}")
    public List<Questao> encontrarQuestoesPorModeloQuestionario(
            @PathVariable(name = "modeloquestionarioId") Long modeloquestionarioId) {
        List<Questao> questoesDoQuestionario = questaoService
                .encontrarQuestoesPorModeloQuestionario(modeloquestionarioId).stream()
                .collect(Collectors.toList());
        return questoesDoQuestionario;
    }
}
