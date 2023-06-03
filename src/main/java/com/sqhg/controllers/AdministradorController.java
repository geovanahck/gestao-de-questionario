package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.services.AdministradorService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class AdministradorController {

    private AdministradorRepository repository;
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }
}
