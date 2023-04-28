package com.sqhg.service;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {

    private static AdministradorRepository administradorRepository;

    public static boolean buscarPorId(long Id) {
        Optional<Administrador> administradorOpt = administradorRepository.findById(Id);
        if (administradorOpt.isPresent()) {

            return true;
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
    }

    @Bean
    public PasswordEncoder getPassWordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}