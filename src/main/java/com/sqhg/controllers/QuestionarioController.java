package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questionario;
import com.sqhg.forms.AdministradorForm;
import com.sqhg.services.AdministradorService;
import com.sqhg.services.QuestionarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/questionario")
public class QuestionarioController {

    private QuestionarioService questionarioService;

    @GetMapping(value="/enviar")
    public String enviarQuestionario(Model model) {
        model.addAttribute("questionario", new AdministradorForm());
        return "envioQuestionario";
    }

    @GetMapping
    public String listaAdministradores(Model model,
                                       @RequestParam(name = "search") Optional<String> search,
                                       @RequestParam(name = "pageSize") Optional<Integer> size,
                                       @RequestParam(name = "page") Optional<Integer> page) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String keyword = search.orElse(null);

        Page<Questionario> questionarioPage = questionarioService
                .acharQuestionarioPorPagina(currentPage, pageSize, keyword);

        model.addAttribute("questionario", questionarioPage);
        model.addAttribute("page", currentPage);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("search", keyword);
        return "listaQuestionario";
    }

}
