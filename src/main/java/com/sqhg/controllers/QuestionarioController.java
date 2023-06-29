package com.sqhg.controllers;

import lombok.AllArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.SuperiorImediato;
import com.sqhg.repositories.ModeloQuestionarioRepository;
import com.sqhg.services.QuestionarioService;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/questionario")
public class QuestionarioController {

    private final QuestionarioService questionarioService;
    private final ModeloQuestionarioRepository modeloQuestionarioRepository;

    @GetMapping(value = ("/lista"))
    public String listaQuestionarios(Model model,
            @RequestParam(name = "search") Optional<String> search,
            @RequestParam(name = "pageSize") Optional<Integer> size,
            @RequestParam(name = "page") Optional<Integer> page) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String keyword = search.orElse(null);

        Page<Questionario> questionarioPage = questionarioService
                .acharQuestionariosPorPagina(currentPage, pageSize, keyword);

        model.addAttribute("questionarios", questionarioPage);
        model.addAttribute("page", currentPage);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("search", keyword);
        model.addAttribute("hasNext", questionarioPage.hasNext());
        return "listaQuestionario";
    }

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
    public String salvarQuestionario(
            Model model,
            @RequestParam(name = "superiores") List<SuperiorImediato> superiores,
            @PathVariable(name = "id") Long questionarioid,
            @RequestParam(name = "dataInicio") Date dataInicio,
            @RequestParam(name = "dataFim") Date dataFim,
            @RequestParam(name = "horaInicio") String horaInicioStr,
            @RequestParam(name = "horaFim") String horaFimStr) {

        Optional<ModeloQuestionario> modeloquestionario = modeloQuestionarioRepository.findById(questionarioid);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime horaInicio = LocalTime.parse(horaInicioStr, timeFormatter);
        LocalTime horaFim = LocalTime.parse(horaFimStr, timeFormatter);

        if (!modeloquestionario.isPresent()) {
            return "redirect:/modelo-questionario";
        } else {
            ModeloQuestionario questionarioexistente = modeloquestionario.get();
            String codigoQuestionario = questionarioService.salvarQuestionario(superiores, questionarioexistente,
                    dataInicio, dataFim, horaInicio, horaFim);
            model.addAttribute("codigoQuestionario", codigoQuestionario);
            return "redirect:/questionario/lista";
        }
    }
}
