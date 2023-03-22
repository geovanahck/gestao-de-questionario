package com.sqhg.controllers;

import java.util.List;

import com.sqhg.entities.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqhg.repositories.AdministradorRepository;

@RestController
@RequestMapping(value = "/users")
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
}