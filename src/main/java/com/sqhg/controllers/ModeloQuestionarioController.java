package com.sqhg.controllers;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.services.ModeloQuestionarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/modelo-questionario")
@AllArgsConstructor
public class ModeloQuestionarioController {

    private final ModeloQuestionarioService modeloQuestionarioService;

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
