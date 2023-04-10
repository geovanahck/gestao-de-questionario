package com.sqhg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value = "select * from administrador where cracha = :cracha and senha = :senha", nativeQuery = true)
    public Administrador Login(String cracha, String senha);

    @Query("SELECT a FROM Administrador a WHERE a.cracha LIKE %:filtro% OR a.nome LIKE %:filtro% OR a.email LIKE %:filtro% OR a.telefone LIKE %:filtro%")
    Page<Administrador> buscarAdministradoresPorFiltro(String filtro, Pageable pageable);
}
