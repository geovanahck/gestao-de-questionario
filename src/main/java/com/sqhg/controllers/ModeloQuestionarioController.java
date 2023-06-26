package com.sqhg.controllers;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questao;
import com.sqhg.services.ModeloQuestionarioService;
import com.sqhg.services.QuestaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/modelo-questionario")
@AllArgsConstructor
public class ModeloQuestionarioController {

    private final ModeloQuestionarioService modeloQuestionarioService;
    private final QuestaoService questaoService;

    @GetMapping("/novo")
    public String telaCriarModeloQuestionario(Model model, Optional<Integer> currentPage) {
        int page = currentPage.orElse(1);
        Page<Questao> questoes = questaoService.listarQuestoesPorPagina(PageRequest.of(page - 1, 10));
        model.addAttribute("modeloQuestionario", new ModeloQuestionario());
        model.addAttribute("questoes", questoes.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", questoes.getTotalPages());
        model.addAttribute("totalQuestoes", questoes.getTotalElements());
        model.addAttribute("hasNext", questoes.hasNext());
        return "criarModeloQuestionario";
    }

    @PostMapping("/novo")
    public String salvarModeloQuestionario(@ModelAttribute("modeloQuestionario") ModeloQuestionario modeloQuestionario, BindingResult result) {
        if (result.hasErrors()) {
            return "listarQuestao";
        }
        modeloQuestionarioService.salvar(modeloQuestionario);
        return "redirect:/modelo-questionario/novo";
    }
}
