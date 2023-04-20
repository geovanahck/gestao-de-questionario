package com.sqhg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {

    @Autowired
    private static AdministradorRepository administradorRepository;
    
    public static Administrador buscarPorId(Long Id) {
        Optional<Administrador> administradorOpt = administradorRepository.findById(Id);
        if (administradorOpt.isPresent()) {
            Administrador administrador = administradorOpt.get();
           return administrador;
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    } 

}
