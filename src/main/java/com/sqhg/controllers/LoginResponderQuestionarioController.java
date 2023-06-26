package com.sqhg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqhg.entities.Opcao;
import com.sqhg.entities.Questao;
import com.sqhg.services.OpcaoService;
import com.sqhg.services.QuestionarioService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/{codigoQuestionario}")
@AllArgsConstructor
public class LoginResponderQuestionarioController {

    private final QuestionarioService questionarioService;
    private final OpcaoService opcaoService;
    //TO DO
    //Front nao foi ajustado as rotas
    //alinhar as branches para conseguir testar 
    //testar Login primeiro para retornar na primeira questao do questionario
            //adicionar no banco para testar
    @GetMapping
    public String irParaPrimeiraQuestaoQuestionario(Model model,
            @PathVariable(name = "codigoQuestionario") int codigoQuestionario) {

        List<Questao> questoes = questionarioService
                .findQuestionsByQuestionarioCodigo(codigoQuestionario);

        //testar se retorna a pagina certa primeiro depois adicionar os dados: administrador: nome e questao:número
        if (!questoes.isEmpty()) {
            Questao primeiraQuestao = questoes.get(0);

            if (primeiraQuestao.getTipo() == 3) { //adicionar questao no model
                return "responderQuestaoAberta";
            }

            if (primeiraQuestao.getTipo() == 2) {
                List<Opcao> opcoes = opcaoService.findOpcoesByQuestaoId(primeiraQuestao.getId());
               // model.addAttribute("alternativas", opcoes); 
                return "responderQuestaoAlternativa";
            }
            if (primeiraQuestao.getTipo() == 1) { //adicionar questao no model
                return "responderQuestaoAberta";
            }
        }
        return "loginUsuario";
    }
}
