package com.sqhg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

@Controller
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @GetMapping("/lista")
    public ModelAndView listaAdmin() {
        List<Administrador> administradores = this.repository.findAll();
        ModelAndView mv = new ModelAndView("listaAdm");
        mv.addObject("administradores", administradores);
        return mv;
    }

}