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

        Page<Administrador> administradores = this.administradorRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listaAdm");

        if (Param == null) {
            administradores = this.administradorRepository.findAll(pageable);
        } else {
            administradores = this.administradorRepository.buscarAdministradoresPorFiltro(Param, pageable);
        }

        int quantidadeExibida = administradores.getNumberOfElements();
        long quantidadeTotal = administradores.getTotalElements();

        mv.addObject("administradores", administradores);
        mv.addObject("page", page);
        mv.addObject("pageSize", size);
        mv.addObject("quantidadeExibida", quantidadeExibida);
        mv.addObject("quantidadeTotal", quantidadeTotal);

        return mv;

    }
}
