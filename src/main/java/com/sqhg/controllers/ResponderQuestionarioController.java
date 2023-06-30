package com.sqhg.controllers;

import com.sqhg.entities.Questao;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.Resposta;
import com.sqhg.services.QuestionarioService;
import com.sqhg.services.RespostaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionarios/responder/{codigoQuestionario}")
@AllArgsConstructor
public class ResponderQuestionarioController {

    private final QuestionarioService questionarioService;
    private final RespostaService respostaService;

    @PostMapping("/{numeroQuestao}")
    public String salvarQuestaoeIrParaProximaQuestao(Model model,
                                                     @PathVariable(name = "codigoQuestionario") Integer codigoQuestionario,
                                                     @PathVariable(name = "numeroQuestao") int numeroQuestao,
                                                     @ModelAttribute Resposta resposta) {

        Questionario questionario = questionarioService.acharQuestionarioPorCodigo(codigoQuestionario);
        if (questionario == null) {
            return "redirect:/";
        }

        Questao questaoAtual = questionario.getModeloQuestionario().getQuestoes().get(numeroQuestao);
        resposta.setQuestionario(questionario);
        resposta.setQuestao(questaoAtual);
        respostaService.salvarResposta(resposta);

        return "redirect:/questionarios/responder/{%d}/{%d}".formatted(codigoQuestionario, numeroQuestao + 1);
    }
}
