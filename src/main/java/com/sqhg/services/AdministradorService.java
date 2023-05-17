package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.forms.AdministradorForm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    Optional<Administrador> acharAdministradorPorId(Long id);

    List<Administrador> acharTodosAdministradores();

    Page<Administrador> acharAdministradoresPorPagina(int pageNo, int pageSize, String keyword);

    void salvarAdministrador(Administrador administrador);

    void salvarAdministradorPorForm(AdministradorForm administradorForm);

    Administrador acharAdministradorPorCracha(String cracha);

    void deletar(Long id);
}
