package com.sqhg.controllers;

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

    @RequestMapping
    public ModelAndView findAdministradorbyName(@RequestParam(required = false) String Param,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        ModelAndView mv = new ModelAndView("listaAdm");
        Pageable pageable = PageRequest.of(page, size);
        if (Param != null) {
            Page<Administrador> filtered_administradores = this.administradorRepository.findByNomeContaining(Param,
                    pageable);
            mv.addObject("administradores", filtered_administradores);
        } else {
            Page<Administrador> administradores = this.administradorRepository.findAll(pageable);
            mv.addObject("administradores", administradores);
        }

        return mv;
    }

}