package com.sqhg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqhg.entities.Questao;
import com.sqhg.services.QuestaoService;

@Controller
public class QuestionarioController {
    private QuestaoService questaoService;

    public QuestionarioController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @GetMapping(value = "/questionario")
    public String telaResponderQuestionario(Model model) {

        return "responderQuestaoEL";
    }

    @PostMapping(value = "/respostaquestionario")
    public void salvarResposta(String nota) {
        System.out.println(nota);
    }

    @PostMapping(value = "/respostaAlternativas")
    public void salvarRespostaAlternativas(
            @RequestParam("alternativasSelecionadas") List<String> alternativasSelecionadas) {
        System.out.println(alternativasSelecionadas);
    }
    

    @GetMapping(value = "/questaoalternativa")
    public String getQuestaoAlternativa(Model model) {
        List<Questao> questoes = questaoService.obterDescricoes();
        model.addAttribute("alternativas", questoes);
        return "responderQuestaoAlternativa";
    }

}
