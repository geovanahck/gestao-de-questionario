package com.sqhg.controllers;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.SuperiorImediato;
import com.sqhg.services.QuestionarioService;

@Controller
@RequestMapping(path = "/questionario")
@AllArgsConstructor
public class QuestionarioController {

    private QuestionarioService questionarioService;

    @GetMapping(value = ("/{id}"))
    public String filtrarSuperiores(Model model,
            @RequestParam(name = "area") Optional<List<String>> areas,
            @RequestParam(name = "cargo") Optional<List<String>> cargos,
            @PathVariable Long id) {

        List<SuperiorImediato> superiores = questionarioService.buscarSuperioresPorAreasECargos(
                areas.orElse(Collections.emptyList()), cargos.orElse(Collections.emptyList()));

        model.addAttribute("superiores", superiores);
        model.addAttribute("selectedAreas", areas.orElse(Collections.emptyList()));
        model.addAttribute("selectedCargos", cargos.orElse(Collections.emptyList()));
        return "envioQuestionario";
    }

    @PostMapping(value = ("/{id}"))
    public String enviarQuestionario(Model model,
            @RequestParam(name = "superiores") Optional<List<Integer>> superiores,
            @PathVariable Long id) {

        // questionarioService.enviarQuestionario(superiores);
        return "envioQuestionario";
    }
}
