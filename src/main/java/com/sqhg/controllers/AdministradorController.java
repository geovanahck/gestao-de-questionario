package com.sqhg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

@Controller

public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    // @GetMapping(value = "/listaAdmin")
    // public ModelAndView listaAdmin() {
    // List<Administrador> administradores = this.repository.findAll();
    // ModelAndView mv = new ModelAndView("listaAdm");
    // mv.addObject("administradores", administradores);
    // return mv;
    // }

    // @GetMapping
    // public List<Administrador> findAll() {
    // List<Administrador> result = repository.findAll();
    // return result;
    // }

    // @GetMapping(value = "/{id}")
    // public Administrador findById(@PathVariable Long id) {
    // Administrador result = repository.findById(id).get();
    // return (Administrador) result;
    // }

    // @GetMapping(value = "/listaAdm")
    // public String login() {

    // // carregaAdministradoresPorPagina(null, null);
    // return "listaAdm";
    // }

    // public ModelAndView listaAdministrador() {
    // List<Administrador> administradores = this.repository.findAll();
    // ModelAndView modelAndView = new ModelAndView("listaAdm");
    // // para o objeto de pessoas joga a lista de volta
    // modelAndView.addObject("administradores", administradores);

    // return modelAndView;
    // }
    // @GetMapping(value = "/listaAdm")
    // vai carregar sempre 5 ent size 5
    // public ModelAndView listaAdmin(@PageableDefault(size = 5) Pageable pageable,
    // ModelAndView modelAndView) { // modelAndView controlador de tela
    // List<Administrador> administradores = this.repository.findAll();
    // Page<Administrador> pageAdmin = this.repository.findAll(pageable); // vai
    // trazer páginado pag1 pag2 etc

    // // para o objeto de pessoas joga a lista de volta
    // modelAndView.addObject("administradores", administradores);

    // // vai carregar do banco
    // modelAndView.addObject("administradores", pageAdmin);// variavel pessoa a
    // nossa paginação dos objetos

    // modelAndView.setViewName("listaAdm"); // retorno da tela

    // return modelAndView;

    // }
    @GetMapping(value = "/listaAdm")
    public ModelAndView listaAdm() {
        List<Administrador> aList = this.repository.findAll();
        ModelAndView modelAndView = new ModelAndView("listaAdm");
        modelAndView.addObject("administradores", aList);
        return modelAndView;
    }
}