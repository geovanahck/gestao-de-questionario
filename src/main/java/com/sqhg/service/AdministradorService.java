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
    private AdministradorRepository administradorRepository;
    
    public Administrador buscarPorId(Long id) {
        Optional<Administrador> administradorOpt = administradorRepository.findById(id);
        if (administradorOpt.isPresent()) {
            Administrador administrador = administradorOpt.get();
            administrador.setNome("Novo nome do usuário");
            administradorRepository.save(administrador);
            return administrador;
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    } 

}
