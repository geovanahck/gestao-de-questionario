package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Role;
import com.sqhg.repositories.AdministradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {

    private AdministradorRepository administradorRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void salvarAdministrador(Administrador administrador) {
        administrador.setSenha(passwordEncoder.encode(administrador.getSenha()));
        administrador.setRole(Role.ADMIN);
        administradorRepository.save(administrador);
    }

    @Override
    public Administrador acharAdministradorPorCracha(String cracha) {
        return administradorRepository.findByCracha(cracha);
    }
}
