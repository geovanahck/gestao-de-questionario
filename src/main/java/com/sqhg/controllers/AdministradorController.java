package com.sqhg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping(value = "/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(value = "/pagina")
    public ModelAndView listAll(@RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Administrador> administradores = this.administradorRepository.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("listaAdm");
        modelAndView.addObject("administradores", administradores);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView findAdministrador(@RequestParam(required = false) String Param,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);
        

        if (Param == null) {
            Page<Administrador> administradores = this.administradorRepository.findAll(pageable);
        ModelAndView mv_pagina = new ModelAndView("listaAdm");
        mv_pagina.addObject("administradores", administradores);
            return mv_pagina;
        } else {
            ModelAndView mv_filtered = new ModelAndView("listaAdm");
            Page<Administrador> administradores2 = this.administradorRepository.findByNome(Param,
                    pageable);
            mv_filtered.addObject("administradores", administradores2);
            return mv_filtered;
        }
        
    }
}
