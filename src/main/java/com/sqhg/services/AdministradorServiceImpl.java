package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Role;
import com.sqhg.repositories.AdministradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {

    private AdministradorRepository administradorRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Administrador> acharAdministradorPorId(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public List<Administrador> acharTodosAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Page<Administrador> acharAdministradoresPorPagina(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (keyword == null) {
            return administradorRepository.findAll(pageable);
        } else {
            return administradorRepository.buscarAdministradoresPorFiltro(keyword, pageable);
        }
    }

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

    @Override
    public void deletar(Long id) {
        administradorRepository.deleteById(id);
    }
}
