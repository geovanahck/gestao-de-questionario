package com.sqhg.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqhg.entities.Area;
import com.sqhg.entities.SuperiorImediato;
import com.sqhg.forms.SuperiorForm;
import com.sqhg.services.AreaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/superiores")
public class SuperiorController {
    private AreaService areaService;

    @GetMapping(value = "/novo")
    public String cadastrarAdministrador(Model model) {
        List<Area> areas = areaService.findAllAreas();
        model.addAttribute("superior", new SuperiorImediato());
        model.addAttribute("areas", areas);
        return "cadSuperior";
    }

    @PostMapping(value = "/novo")
    public String salvarAdministrador(@Valid @ModelAttribute("superior") SuperiorForm superiorForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return "cadAdministrador";
        }
        
        superiorService.salvarAdministradorPorForm(superiorForm);
        return "redirect:/superiores";
    }
}
