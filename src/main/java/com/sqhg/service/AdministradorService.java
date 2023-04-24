package com.sqhg.service;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {

     private static AdministradorRepository administradorRepository;
    
    public long calcularTotalPaginas(int tamanhoPagina) {
        long totalAdministradores = administradorRepository.count();
        return (totalAdministradores + tamanhoPagina - 1) / tamanhoPagina;
    }
    
    public static boolean buscarPorId(int Id) {
        Administrador administradorOpt = administradorRepository.buscarID(Id);
        if (administradorOpt.isPresent()) {
            
           return true;
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    } 

}