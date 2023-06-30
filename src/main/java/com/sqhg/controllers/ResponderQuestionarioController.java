package com.sqhg.controllers;

import com.sqhg.entities.Questao;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.Resposta;
import com.sqhg.entities.TipoQuestao;
import com.sqhg.services.QuestionarioService;
import com.sqhg.services.RespostaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questionario/responder/{codigoQuestionario}")
@AllArgsConstructor
public class ResponderQuestionarioController {

    private final QuestionarioService questionarioService;
    private final RespostaService respostaService;

    @GetMapping("/{numeroQuestao}")
    public String telaQuestao(Model model,
                              @PathVariable(name = "codigoQuestionario") String codigoQuestionario,
                              @PathVariable(name = "numeroQuestao") int numeroQuestao) {
        Questionario questionario = questionarioService.acharQuestionarioPorCodigo(codigoQuestionario);
        if (questionario == null) {
            return "redirect:/login-usuario";
        }

        Questao questaoAtual = questionario.getModeloQuestionario().getQuestoes().get(numeroQuestao - 1);
        model.addAttribute("questao", questaoAtual);
        model.addAttribute("resposta", Resposta.builder().questao(questaoAtual).questionario(questionario).build());
        model.addAttribute("numeroQuestao", numeroQuestao);
        model.addAttribute("codigoQuestionario", codigoQuestionario);
        model.addAttribute("ultimaQuestao", questionario.getModeloQuestionario().getQuestoes().size() == numeroQuestao);

        if (questaoAtual.getTipo().equals(TipoQuestao.MULTIPLA) || questaoAtual.getTipo().equals(TipoQuestao.ALTERNATIVAS)) {
            model.addAttribute("alternativas", questaoAtual.getOpcoes());
            return "responderQuestaoAlternativas";
        } else if (questaoAtual.getTipo().equals(TipoQuestao.ABERTA)) {
            return "responderQuestaoAberta";
        }
        return "responderQuestaoEL";
    }

    @PostMapping("/{numeroQuestao}")
    public String salvarResposta(Model model,
                                 @PathVariable(name = "numeroQuestao") Integer numeroQuestao,
                                 @PathVariable(name = "codigoQuestionario") String codigoQuestionario,
                                 @ModelAttribute Resposta resposta) {
        Questionario questionario = questionarioService.acharQuestionarioPorCodigo(codigoQuestionario);
        if (questionario == null) {
            return "redirect:/login-usuario";
        }
        respostaService.salvarResposta(resposta);
        if (numeroQuestao < questionario.getModeloQuestionario().getQuestoes().size()) {
            return String.format("redirect:/questionario/responder/%s/%d", codigoQuestionario, ++numeroQuestao);
        }
        return "redirect:/questionario/lista";
    }
}
