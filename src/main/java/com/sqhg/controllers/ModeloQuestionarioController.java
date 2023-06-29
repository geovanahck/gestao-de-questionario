package com.sqhg.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questao;
import com.sqhg.services.ModeloQuestionarioService;
import com.sqhg.services.QuestaoService;

import lombok.AllArgsConstructor;

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

    @GetMapping
    public String telaListarModeloQuestionario(Model model,
                                               @RequestParam(name = "search") Optional<String> search,
                                               @RequestParam(name = "pageSize") Optional<Integer> size,
                                               @RequestParam(name = "page") Optional<Integer> page) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String keyword = search.orElse(null);

        Page<ModeloQuestionario> modeloQuestionarioPage = modeloQuestionarioService
                .buscarModeloQuestionarioPorPagina(currentPage, pageSize, keyword);

        model.addAttribute("modeloQuestionarios", modeloQuestionarioPage);
        model.addAttribute("page", currentPage);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("search", keyword);
        model.addAttribute("hasNext", modeloQuestionarioPage.hasNext());
        return "listaModeloQuestionario";
    }

    @GetMapping("/enviar/{id}")
    public String enviar(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        return "redirect:/questionario/" + id;
    }
}
