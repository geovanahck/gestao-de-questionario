package com.sqhg.services;

import com.sqhg.entities.Administrador;

public interface AdministradorService {
    void salvarAdministrador(Administrador administrador);
    Administrador acharAdministradorPorCracha(String cracha);

}
