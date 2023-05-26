package com.sqhg.controllers;

import java.util.List;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestionarioRepository;
import com.sqhg.services.QuestaoService;

@Controller
public class QuestaoController {
    private QuestaoService questaoService;

    public QuestaoController(QuestaoService questaoService) {
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
    public String telaQuestaoAlternativa(Model model) {
        List<Questao> listQuestoes = questaoService.obterDescricoes();
        model.addAttribute("alternativas", listQuestoes);
        return "responderQuestaoAlternativa";
    }

}
