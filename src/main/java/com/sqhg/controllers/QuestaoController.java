package com.sqhg.controllers;

import com.sqhg.entities.TipoQuestao;
import com.sqhg.services.QuestaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.sqhg.entities.Questao;

@Controller
@RequestMapping("/questoes")
@AllArgsConstructor
public class QuestaoController {

    private final QuestaoService questaoService;

    @GetMapping
    public String telaListarQuestoes(Model model, int currentPage) {
        Page<Questao> questoes = questaoService.listarQuestoesPorPagina(PageRequest.of(currentPage - 1, 10));
        model.addAttribute("questoes", questoes.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", questoes.getTotalPages());
        model.addAttribute("totalQuestoes", questoes.getTotalElements());
        model.addAttribute("hasNext", questoes.hasNext());
        return "listarQuestao";
    }

    @GetMapping("/novo")
    public String telaCadastrarQuestao(Model model) {
        return "criarQuestao";
    }

    @PostMapping("/novo")
    public String salvarQuestao(@ModelAttribute("questao") Questao questao, BindingResult result) {
        if (result.hasErrors()) {
            return "criarQuestao";
        }
        if (questao.getTipo().equals(TipoQuestao.MULTIPLA)) {
            if (questao.getOpcoes().isEmpty()) {
                result.addError(new FieldError("questao", "opcoes", "Questões de múltipla escolha devem ter alternativas associadas."));
                return "criarQuestao";
            }
        }
        questaoService.salvarQuestao(questao);
        return "redirect:/questoes";
    }
}
