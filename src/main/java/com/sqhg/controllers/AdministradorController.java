package com.sqhg.controllers;

import java.util.List;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sqhg.entities.Administrador;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    // @GetMapping
    // public List<Administrador> findAll() {
    //     List<Administrador> result = repository.findAll();
    //     return result;
    // }

    // @ModelAttribute(value = "/{id}")
    // public Administrador findById(@PathVariable Long id) {
    //     Administrador result = repository.findById(id).get();
    //     return (Administrador) result;
    // }

    @GetMapping("/lista")
    public ModelAndView listaAdmin() {
        List<Administrador> administradores = this.repository.findAll();
        ModelAndView mv = new ModelAndView("listaAdm");
        mv.addObject("administradores", administradores);
        return mv;
    }    
}