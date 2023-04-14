package com.sqhg.controllers;

import java.util.List;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqhg.entities.Administrador;

@Controller
@RequestMapping(value = "/users")
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @GetMapping
    public List<Administrador> findAll() {
        List<Administrador> result = repository.findAll();
        return result;
    }

    /**
     * @param id
     * @return
     */

    @GetMapping(value = "/{id}")
    public Administrador findById(@PathVariable Long id) {
        Administrador result = repository.findById(id).get();
        return (Administrador) result;
    }

    // Cadastro de Administrador
    @Autowired
    @GetMapping (value="/cadastroadm")
    public String cadAdministrador (){
        return "cadAdministrador";
    }

    

}