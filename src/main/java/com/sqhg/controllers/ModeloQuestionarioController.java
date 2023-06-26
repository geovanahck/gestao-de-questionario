package com.sqhg.controllers;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questao;
import com.sqhg.services.ModeloQuestionarioService;
import com.sqhg.services.QuestaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/modelo-questionario")
@AllArgsConstructor
public class ModeloQuestionarioController {

    private final ModeloQuestionarioService modeloQuestionarioService;
    private final QuestaoService questaoService;

    @GetMapping("/novo")
    public String telaCriarModeloQuestionario(Model model) {
        List<Questao> questoes = questaoService.listarTodasQuestoes();
        model.addAttribute("modeloQuestionario", new ModeloQuestionario());
        model.addAttribute("questoes", questoes);
        return "criarModeloQuestionario";
    }

    @PostMapping("/novo")
    public String salvarModeloQuestionario(@ModelAttribute("modeloQuestionario") ModeloQuestionario modeloQuestionario, BindingResult result) {
        if (result.hasErrors()) {
            return "criarModeloQuestionario";
        }
        if (modeloQuestionario.getQuestoes().isEmpty()) {
            result.rejectValue("questoes", "", "Não pode ser vazio.");
            return "criarModeloQuestionario";
        }
        modeloQuestionarioService.salvar(modeloQuestionario);
        return "redirect:/modelo-questionario/novo";
    }
}
