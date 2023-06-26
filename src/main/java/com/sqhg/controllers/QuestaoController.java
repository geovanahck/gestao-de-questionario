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
        return "redirect:/modelo-questionario/novo";
    }
}
