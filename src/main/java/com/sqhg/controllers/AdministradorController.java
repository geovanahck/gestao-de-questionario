package com.sqhg.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import jakarta.persistence.Entity;

@RestController
@RequestMapping(value = "/adm")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(value = "Ativos")
    public ModelAndView listAllActives(@RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Administrador> administradores = this.administradorRepository.findAllActives(pageable);
        ModelAndView modelAndView = new ModelAndView("listaAdm");
        modelAndView.addObject("administradores", administradores);
        return modelAndView;
    }

    @PostMapping(value = "/editar")
    public ModelAndView receberSelecionado(@RequestBody long id) {
         Administrador administrador = administradorRepository.findById(id).get();
        System.out.println(id); // exibir selecionado no console do servidor
        // faça algo com o valor de selecionado aqui
        ModelAndView modelteste = new ModelAndView("");
        modelteste.addObject(null, administrador);
        return modelteste;
      }

    // public long editaradministrador(@RequestParam(name = "id") long adminselected,
    //         @RequestParam(name = "acao") String acao) {
    //             System.out.println(acao + " " + adminselected);
                
    

    @PostMapping(value = "administradores")
    public ModelAndView findAdministrador(@RequestParam(required = false) String Param,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Administrador> administradores = this.administradorRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listaAdm");

        if (Param == null) {
            administradores = this.administradorRepository.findAllActives(pageable);
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
