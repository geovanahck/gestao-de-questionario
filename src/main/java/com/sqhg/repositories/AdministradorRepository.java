package com.sqhg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqhg.entities.Administrador;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Query("SELECT a FROM Administrador a WHERE (a.cracha LIKE %:filtro% OR a.nome LIKE %:filtro% OR a.email LIKE %:filtro% OR a.telefone LIKE %:filtro%)")
    Page<Administrador> buscarAdministradoresPorFiltro(@Param("filtro") String filtro, Pageable pageable);

    Administrador findByCracha(String cracha);
}
