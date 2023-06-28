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
import com.sqhg.repositories.ModeloQuestionarioRepository;
import com.sqhg.services.QuestionarioService;

@Controller
@RequestMapping(path = "/questionario")
@AllArgsConstructor
public class QuestionarioController {

    private final QuestionarioService questionarioService;
    private final ModeloQuestionarioRepository modeloQuestionarioRepository;

    @GetMapping(value = ("/{id}"))
    public String filtrarSuperiores(Model model,
            @RequestParam(name = "area") Optional<List<String>> areas,
            @RequestParam(name = "cargo") Optional<List<String>> cargos,
            @PathVariable Long id) {

        Optional<ModeloQuestionario> modeloquestionario = modeloQuestionarioRepository.findById(id);
        if (!modeloquestionario.isPresent()) {
            return "redirect:/modelo-questionario";
        } else {
            List<SuperiorImediato> superiores = questionarioService.buscarSuperioresPorAreasECargos(
                    areas.orElse(Collections.emptyList()), cargos.orElse(Collections.emptyList()));
            model.addAttribute("superiores", superiores);
            model.addAttribute("selectedAreas", areas.orElse(Collections.emptyList()));
            model.addAttribute("selectedCargos", cargos.orElse(Collections.emptyList()));
            return "envioQuestionario";
        }
    }

    @PostMapping(value = ("/{id}"))
    public String salvarQuestionario(Model model,
            @RequestParam(name = "superiores") List<SuperiorImediato> superiores,
            @PathVariable(name = "id") Long questionarioid) {

        Optional<ModeloQuestionario> modeloquestionario = modeloQuestionarioRepository.findById(questionarioid);

        if (!modeloquestionario.isPresent()) {
            return "redirect:/modelo-questionario";
        } else {
            ModeloQuestionario questionarioexistente = modeloquestionario.get();
            String codigoQuestionario = questionarioService.salvarQuestionario(superiores, questionarioexistente);
            model.addAttribute("codigoQuestionario", codigoQuestionario);
            return null; //verificar para qual tela vai retornar
        }
    }
}
