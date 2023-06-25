package com.sqhg.controllers;

import com.sqhg.services.QuestaoService;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questao;

@Controller
@RequestMapping("/questoes")
@AllArgsConstructor
public class QuestaoController {

    private final QuestaoService questaoService;

    @GetMapping
    public String telaListarQuestoes(Model model, Optional<Integer> currentPage) {
        int page = currentPage.orElse(1);
        Page<Questao> questoes = questaoService.listarQuestoesPorPagina(PageRequest.of(page - 1, 10));
        model.addAttribute("modeloQuestionario", new ModeloQuestionario());
        model.addAttribute("questoes", questoes.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", questoes.getTotalPages());
        model.addAttribute("totalQuestoes", questoes.getTotalElements());
        model.addAttribute("hasNext", questoes.hasNext());
        return "listarQuestao";
    }

    @GetMapping("/novo")
    public String telaCadastrarQuestao(Model model) {
        model.addAttribute("questao", new Questao());
        return "criarQuestao";
    }

    @PostMapping("/novo")
    public String salvarQuestao(@ModelAttribute("questao") Questao questao, BindingResult result) {
        if (result.hasErrors()) {
            return "criarQuestao";
        }
        questaoService.salvarQuestao(questao);
        return "redirect:/questoes";
    }

    @PostMapping("/modeloQuestionario/novo")
    public String salvarModeloQuestionario(@ModelAttribute("modeloQuestionario") ModeloQuestionario modeloQuestionario, BindingResult result) {
        if (result.hasErrors()) {
            return "listarQuestao";
        }
        return "redirect:/questoes";
    }
}
