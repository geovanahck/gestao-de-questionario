package com.sqhg.controllers;

import java.util.List;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @GetMapping
    public List<Administrador> findAll() {
        List<Administrador> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Administrador findById(@PathVariable Long id) {
        Administrador result = repository.findById(id).get();
        return (Administrador) result;
    }

    @PostMapping(value="/administradores")
    public void salvarAdministrador (@RequestBody Administrador administrador){
        repository.save(administrador);
    }


}