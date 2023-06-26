package com.sqhg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqhg.entities.Questao;
import com.sqhg.services.QuestionarioService;
import com.sqhg.services.RespostaService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/{codigoQuestionario}")
@AllArgsConstructor
public class ResponderQuestionarioController {

    private final QuestionarioService questionarioService;
    private final RespostaService respostaService;

    @PostMapping("/{numeroQuestao}")
    public String SalvarQuestaoeIrParaProximaQuestao(@PathVariable(name = "numeroQuestao") int numeroQuestao,
            @PathVariable(name = "codigoQuestionario") int codigoQuestionario) {

        List<Questao> questoes = questionarioService.findQuestionsByQuestionarioCodigo(codigoQuestionario);
        // TO DO :
        //adicionar os atributos na URL de todas as paginas
        //Implementar: identificar qual numero da questao para retornar
        //Implementar: Salvar a resposta e de qual questao é
        //Remover botão de questao anterior do front
        //respostaService.saveResposta(resposta);

        int proximaQuestao = numeroQuestao + 1;
        return "redirect:/" + codigoQuestionario + proximaQuestao;
    }
}
