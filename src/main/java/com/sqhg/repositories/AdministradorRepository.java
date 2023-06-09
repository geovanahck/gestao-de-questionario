package com.sqhg.repositories;

import com.sqhg.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByCracha(String cracha);
}
